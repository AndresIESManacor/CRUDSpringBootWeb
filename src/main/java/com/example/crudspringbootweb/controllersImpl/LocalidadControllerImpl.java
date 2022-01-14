package com.example.crudspringbootweb.controllersImpl;

import com.example.crudspringbootweb.controllers.LocalidadController;
import com.example.crudspringbootweb.entity.Factura;
import com.example.crudspringbootweb.entity.Localidad;
import com.example.crudspringbootweb.service.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class LocalidadControllerImpl implements LocalidadController {

    @Autowired
    LocalidadService localidadService;

    //////////////         LOCALIZACION    FORMULARIS     ////////////////////

    @RequestMapping(value = "/localidad/create", method = RequestMethod.GET)
    public String create(ModelMap model) {
        model.addAttribute("type","localidad-create");
        model.addAttribute("object",new Localidad());
        return "formularis/layout-form";
    }

    @RequestMapping(value = "/localidad/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, ModelMap model) {
        Optional<Localidad> localidad = localidadService.findLocalidadById(id);
        if (localidad.isPresent()) {
            model.addAttribute("type","localidad-update");
            model.addAttribute("object",localidad.get());
            return "formularis/layout-form";
        }
        model.addAttribute("error","LOCALIDAD SELECTED DOESNT PRESENT");
        return "links";
    }


    //////////////         LOCALIZACION  ACTIONS       ////////////////////


    @RequestMapping(value = "/localidad/save",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public String save(@ModelAttribute @Valid Localidad localidad, BindingResult errors, ModelMap model) {
        inicializeModelMap(model);

        if(errors.hasErrors()) {
            model.addAttribute("type","localidad-create");
            model.addAttribute("object",new Localidad());
            return "redirect:/localidad/create";
        }

        Optional<Localidad> requestLocalidad = localidadService.findLocalidadById(localidad.getId_localidad());
        if (requestLocalidad.isPresent()) {
            model.addAttribute("type","factura-create");
            model.addAttribute("object",new Factura());
            model.addAttribute("error","TRYING TO SAVE FACTURA THAT EXIST");
        } else {
            //MIRAR TAMBIEN POR EL NOMBRE PARA QUE HAYA DOS REPETIDOS
            if (!localidadService.findLocalidadByNombre_localidad(localidad.getNombre_localidad()).isEmpty()) {
                model.addAttribute("error","name allready exist");
            } else {
                saveLocalidad(localidad);
            }
        }
        return show(model);
    }

    @RequestMapping(value = "/localidad/put",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public String put(@ModelAttribute Localidad localidad, BindingResult errors,ModelMap model) {
        inicializeModelMap(model);

        if(errors.hasErrors()) {
            model.addAttribute("type","localidad-create");
            model.addAttribute("object",new Localidad());
            return "redirect:/localidades";
        }

        Optional<Localidad> localidadUpdate = localidadService.findLocalidadById(localidad.getId_localidad());
        if (localidadUpdate.isPresent()) {
            if (isNombreTaken(localidad,localidadUpdate.get())) {
                model.addAttribute("error","name allready exist");
            } else {
                updateLocalidad(localidad);
            }
        } else {
            model.addAttribute("error","localidad id doesnt exist");
        }

        return show(model);
    }

    @RequestMapping(value = "/localidad/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public RedirectView delete(@PathVariable int id, ModelMap model) {
        Optional<Localidad> localidad =  localidadService.findLocalidadById(id);
        if (localidad.isPresent()) {
            deleteLocalidadById(id);
        } else {
            model.addAttribute("error","LOCALIDAD NOT FOUNDED");
        }
        return new RedirectView("/localidades");
    }

    @RequestMapping(value = "/localidades",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @Override
    public String show(ModelMap model) {
        model.addAttribute("localidades",localidadService.findAllLocalidad());
        return "tables/layout-table";
    }

    @RequestMapping(value = "/localidad/{id}",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @Override
    public String findLocalidadById(@PathVariable int id, ModelMap model) {
        Optional<Localidad> Localidad = localidadService.findLocalidadById(id);
        if (Localidad.isPresent()) {
            model.addAttribute("localidad",Localidad.get());
            return "tables/layout-table";
        }
        model.addAttribute("error","FACTURA NOT FOUNDED");
        return "links";
    }


    /* ------------------------------------------ */


    @Override
    public void saveLocalidad(Localidad localidad) {
        if (localidad!=null) {
            localidadService.saveLocalidad(localidad);
        }
    }

    public boolean checkName(String name) {
        return !localidadService.findLocalidadByNombre_localidad(name).isEmpty();
    }

    @Override
    public String deleteLocalidadById(int id) {
        return localidadService.deleteLocalidad(id);
    }

    @Override
    public String updateLocalidad(Localidad localidadNew) {
        return localidadService.updateLocalidad(localidadNew);
    }

    public boolean isNombreTaken(Localidad localidad, Localidad localidadUpdate) {
        if (localidad.getNombre_localidad().equals(localidadUpdate.getNombre_localidad())) {
            return false;
        } else {
            return checkName(localidad.getNombre_localidad());
        }
    }

    public void inicializeModelMap(ModelMap model) {
        model.remove("localidad");
        model.remove("localidades");
        model.remove("error");
    }
}
