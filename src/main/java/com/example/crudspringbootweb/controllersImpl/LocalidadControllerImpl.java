package com.example.crudspringbootweb.controllersImpl;

import com.example.crudspringbootweb.controllers.LocalidadController;
import com.example.crudspringbootweb.entity.Factura;
import com.example.crudspringbootweb.entity.Localidad;
import com.example.crudspringbootweb.service.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public String save(@ModelAttribute Localidad localidad) {
        saveLocalidad(localidad);
        return "links";
    }

    @RequestMapping(value = "/localidad/put",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public String put(@ModelAttribute Localidad localidad) {
        updateLocalidad(localidad);
        return "links";
    }

    @RequestMapping(value = "/localidad/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public String delete(@PathVariable int id, ModelMap model) {
        Optional<Localidad> localidad =  localidadService.findLocalidadById(id);
        if (localidad.isPresent()) {
            deleteLocalidadById(id);
        } else {
            model.addAttribute("error","LOCALIDAD NOT FOUNDED");
        }
        return "links";
    }

    @RequestMapping(value = "/localidades",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @Override
    public String getAllLocalidad(ModelMap model) {
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
    public Localidad saveLocalidad(Localidad localidad) {
        if (localidad!=null) {
            return localidadService.saveLocalidad(localidad);
        }
        return null;
    }

    @Override
    public String deleteLocalidadById(int id) {
        return localidadService.deleteLocalidad(id);
    }

    @Override
    public String updateLocalidad(Localidad localidadNew) {
        return localidadService.updateLocalidad(localidadNew);
    }
}
