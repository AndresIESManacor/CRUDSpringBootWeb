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

    // http://localhost:8888/localidad/add (CREATE FACTURA)
    @RequestMapping(value = "/localidad/add",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public String localidadadd(
            @RequestParam(value="nombreLocalidad", required=true) String nombreLocalidad,
            @RequestParam(value="codigoPostal", required=true) String codigoPostal,
            ModelMap model) {
        try {
            Localidad localidad = new Localidad();
            localidad.setNombreLocalidad(nombreLocalidad);
            localidad.setCodigoPostal(Integer.parseInt(codigoPostal));
            saveLocalidad(localidad);
            model.addAttribute("localidades",localidadService.findAllLocalidad());
        } catch (Exception e) {
            return null;
        }
        return "tables/layout-table";
    }



    // http://localhost:8888/localidad/update (UPDATE FACTURA)
    @RequestMapping(value = "/localidad/update",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public String localidadupdate(
            @RequestParam(value="idLocalidad", required=true) String idLocalidad,
            @RequestParam(value="nombreLocalidad", required=true) String nombreLocalidad,
            @RequestParam(value="codigoPostal", required=true) String codigoPostal,
            ModelMap model) {
        try {
            Localidad localidad = new Localidad();
            localidad.setIdLocalidad(Integer.parseInt(idLocalidad));
            localidad.setNombreLocalidad(nombreLocalidad);
            localidad.setCodigoPostal(Integer.parseInt(codigoPostal));
            updateLocalidad(localidad);
            model.addAttribute("localidades",localidadService.findAllLocalidad());
            return "tables/layout-table";
        } catch (Exception e) {
            model.addAttribute("error",e);
            return "links";
        }
    }

    // http://localhost:8888/localidad/delete/{id} (DELETE ID)
    @RequestMapping(value = "/localidad/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public String localidadDelete(@PathVariable int id, ModelMap model) {
        Optional<Localidad> localidad =  localidadService.findLocalidadById(id);
        if (localidad.isPresent()) {
            model.addAttribute("localidad",localidad.get());
            deleteLocalidadById(id);
            return "tables/layout-table";
        } else {
            model.addAttribute("error","LOCALIDAD NOT FOUNDED");
            return "links";
        }
    }


    /* ------------------------------------------ */


    // http://localhost:8888/localidades (SHOW ALL)
    @RequestMapping(value = "/localidades",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @Override
    public String getAllLocalidad(ModelMap model) {
        model.addAttribute("localidades",localidadService.findAllLocalidad());
        return "tables/layout-table";
    }

    // http://localhost:8888/localidad/String (SHOW ONE)
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
