package com.example.crudspringbootweb.controllersImpl;

import com.example.crudspringbootweb.controllers.FacturaController;
import com.example.crudspringbootweb.entity.Factura;
import com.example.crudspringbootweb.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class FacturaControllerImpl implements FacturaController {

    @Autowired
    FacturaService facturaService;

    // http://localhost:8888/factura/add (CREATE FACTURA)
    @RequestMapping(value = "/factura/add",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public String facturaadd(
            @RequestParam(value="numFactura", required=true) String numFactura,
            @RequestParam(value="direccion", required=true) String direccion,
            @RequestParam(value="importe", required=true) String importe,
            ModelMap model)
    {
        try {
            Factura factura = new Factura();
            factura.setNumFactura(numFactura);
            factura.setDireccion(direccion);
            factura.setImporte(Float.parseFloat(importe));
            saveFactura(factura);
            model.addAttribute("facturas",facturaService.findAllFactura());
        } catch (Exception e) {
            return null;
        }
        return "tables/layout-table";
    }


    // http://localhost:8888/factura/update (UPDATE FACTURA)
    @RequestMapping(value = "/factura/update",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public String facturasupdate(
            @RequestParam(value="numFactura", required=true) String numFactura,
            @RequestParam(value="direccion", required=true) String direccion,
            @RequestParam(value="importe", required=true) String importe,
            ModelMap model)
    {
        try {
            Factura factura = new Factura();
            factura.setNumFactura(numFactura);
            factura.setDireccion(direccion);
            factura.setImporte(Float.parseFloat(importe));
            facturaService.updateFactura(factura);
            model.addAttribute("facturas",facturaService.findAllFactura());
            return "tables/layout-table";
        } catch (Exception e) {
            model.addAttribute("error",e);
            return "links";
        }
    }

    // http://localhost:8888/factura/delete/{id} (DELETE ID)
    @RequestMapping(value = "/factura/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public String facturadelete(@PathVariable String id, ModelMap model) {
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


    /* ------------------------------------------ */

    // http://localhost:8888/facturas (SHOW ALL)
    @RequestMapping(value = "/facturas",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @Override
    public String getAllFactura(ModelMap model) {
        model.addAttribute("facturas",facturaService.findAllFactura());
        return "tables/layout-table";
    }

    // http://localhost:8888/factura/String (SHOW ONE)
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
