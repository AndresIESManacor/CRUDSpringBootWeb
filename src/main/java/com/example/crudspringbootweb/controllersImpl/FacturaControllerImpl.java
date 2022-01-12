package com.example.crudspringbootweb.controllersImpl;

import com.example.crudspringbootweb.controllers.FacturaController;
import com.example.crudspringbootweb.entity.Factura;
import com.example.crudspringbootweb.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class FacturaControllerImpl implements FacturaController {

    @Autowired
    FacturaService facturaService;

    //////////////         FACTURAS FORMULARIOS        ////////////////////

    @RequestMapping(value = "/factura/create", method = RequestMethod.GET)
    public String create(ModelMap model) {
        model.addAttribute("type","factura-create");
        model.addAttribute("object",new Factura());
        return "formularis/layout-form";
    }

    @RequestMapping(value = "/factura/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable String id, ModelMap model) {
        Optional<Factura> factura = facturaService.findFacturaById(id);
        if (factura.isPresent()) {
            model.addAttribute("type","factura-update");
            model.addAttribute("object",factura.get());
            return "formularis/layout-form";
        }
        model.addAttribute("error","FACTURA SELECTED DOESNT PRESENT");
        return "links";
    }

    //////////////         ROUTES        ////////////////////

    @RequestMapping(value = "/factura/save",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public String save(@ModelAttribute Factura factura, ModelMap model) {
        saveFactura(factura);
        return "links";
    }


    @RequestMapping(value = "/factura/put",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public String put(@ModelAttribute Factura factura, ModelMap model) {
            updateFactura(factura);
            return "links";
    }

    @RequestMapping(value = "/factura/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public String delete(@PathVariable String id, ModelMap model) {
        Optional<Factura> factura =  facturaService.findFacturaById(id);
        if (factura.isPresent()) {
            model.addAttribute("factura",factura.get());
            deleteFacturaById(id);
            return "tables/layout-table";
        } else {
            model.addAttribute("error","FACTURA NOT FOUNDED");
            return "links";
        }

    }

    @RequestMapping(value = "/facturas",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @Override
    public String getAllFactura(ModelMap model) {
        model.addAttribute("facturas",facturaService.findAllFactura());
        return "tables/layout-table";
    }

    @RequestMapping(value = "/factura/{id}",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @Override
    public String findFacturaById(@PathVariable String id, ModelMap model) {
        Optional<Factura> factura = facturaService.findFacturaById(id);
        if (factura.isPresent()) {
            model.addAttribute("factura",factura.get());
            return "tables/layout-table";
        }
        model.addAttribute("error","FACTURA NOT FOUNDED");
        return "links";
    }


    /* ------------------------------------------ */


    @Override
    public Factura saveFactura(Factura factura) {
        if (factura!=null) {
            facturaService.saveFactura(factura);
            return factura;
        }
        return null;
    }

    @Override
    public String deleteFacturaById(String id) {
        return facturaService.deleteFactura(id);
    }

    @Override
    public String updateFactura(Factura facturaNew) {
        return facturaService.updateFactura(facturaNew);
    }
}
