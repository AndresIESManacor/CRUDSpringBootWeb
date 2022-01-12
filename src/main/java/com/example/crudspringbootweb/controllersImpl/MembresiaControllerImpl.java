package com.example.crudspringbootweb.controllersImpl;

import com.example.crudspringbootweb.controllers.MembresiaController;
import com.example.crudspringbootweb.entity.Factura;
import com.example.crudspringbootweb.entity.Membresia;
import com.example.crudspringbootweb.service.FacturaService;
import com.example.crudspringbootweb.service.MembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
public class MembresiaControllerImpl implements MembresiaController {

    @Autowired
    MembresiaService membresiaService;

    @Autowired
    FacturaService facturaService;

    //////////////         MEMBRESIA FORMULARIOS        ////////////////////

    @RequestMapping(value = "/membresia/create", method = RequestMethod.GET)
    public String create(ModelMap model) {
        model.addAttribute("type","membresia-create");
        model.addAttribute("object",new Membresia());
        return "formularis/layout-form";
    }

    @RequestMapping(value = "/membresia/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, ModelMap model) {
        Optional<Membresia> membresia = membresiaService.findMembresiaById(id);
        if (membresia.isPresent()) {
            model.addAttribute("type","membresia-update");
            model.addAttribute("type",membresia.get());
            return "formularis/layout-form";
        }
        model.addAttribute("error","MEMBRESIA SELECTED DOESNT PRESENT");
        return "links";
    }

    //////////////         MEMBRESIA ACTIONS        ////////////////////

    @RequestMapping(value = "/membresia/save",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public RedirectView save(
            @RequestParam(value="fechaInicio", required=true) String fechaInicio,
            @RequestParam(value="fechaFin", required=true) String fechaFin,
            @RequestParam(value="numFactura", required=true) String numFactura,
            ModelMap model) {
        Optional<Factura> factura = facturaService.findFacturaById(numFactura);
        if (factura.isPresent()) {
            saveMembresia(new Membresia(fechaInicio, fechaFin,factura.get()));
        } else {
            model.addAttribute("error","FACTURA NOT FOUND");
        }
        return new RedirectView("/membresias");
    }


    @RequestMapping(value = "/membresia/put",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public RedirectView put(
            @RequestParam(value="idMembresia", required=true) int idMembresia,
            @RequestParam(value="fechaInicio", required=true) String fechaInicio,
            @RequestParam(value="fechaFin", required=true) String fechaFin,
            @RequestParam(value="numFactura", required=true) String numFactura,
            ModelMap model) {
        Optional<Factura> factura = facturaService.findFacturaById(numFactura);
        if (factura.isPresent()) {
            Membresia membresia = new Membresia(idMembresia, fechaInicio, fechaFin,factura.get());
            Optional<Membresia> requestMembresia = membresiaService.findMembresiaById(membresia.getIdMembresia());
            if (requestMembresia.isPresent()) {
                model.addAttribute("error","MEMBRESIA IS PRESENT ALLREADY");
            } else {
                updateMembresia(membresia);
            }
        } else {
            model.addAttribute("error","FACTURA NOT FOUND");
        }
        return new RedirectView("/membresias");
    }

    @RequestMapping(value = "/membresia/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public RedirectView delete(@PathVariable int id, ModelMap model) {
        Optional<Membresia> membresia =  membresiaService.findMembresiaById(id);
        if (membresia.isPresent()) {
            deleteMembresiaById(id);
        } else {
            model.addAttribute("error","MEMBRESIA NOT FOUNDED");
        }
        return new RedirectView("/membresias");
    }

    @RequestMapping(value = "/membresias",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @Override
    public String getAllMembresia(ModelMap model) {
        model.remove("membresia");
        model.addAttribute("membresias",membresiaService.findAllMembresia());
        return "tables/layout-table";
    }

    @RequestMapping(value = "/membresia/{id}",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @Override
    public String findMembresiaById(@PathVariable int id, ModelMap model) {
        Optional<Membresia> membresia = membresiaService.findMembresiaById(id);
        if (membresia.isPresent()) {
            model.addAttribute("membresia",membresia.get());
            return "tables/layout-table";
        }
        model.addAttribute("error","MEMBRESIA NOT FOUNDED");
        return "links";
    }


    //ERROR QUE ME DA PORQUE SI
    @RequestMapping(value = "/membresia/update",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public String errorReturn(ModelMap model) {
        model.addAttribute("error","Page not found");
        return "links";
    }

    /* ------------------------------------------ */



    @Override
    public Membresia saveMembresia(Membresia membresia) {
        if (membresia!=null) {
            return membresiaService.saveMembresia(membresia);
        }
        return null;
    }

    @Override
    public String deleteMembresiaById(int id) {
        return membresiaService.deleteMembresia(id);
    }

    @Override
    public String updateMembresia(Membresia membresiaNew) {
        return membresiaService.updateMembresia(membresiaNew);
    }
}
