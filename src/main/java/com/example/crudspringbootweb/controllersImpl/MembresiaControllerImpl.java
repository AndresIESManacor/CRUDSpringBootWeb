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

    // http://localhost:8888/membresia/add (CREATE FACTURA)
    @RequestMapping(value = "/membresia/add",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public String membresiaadd(
            @RequestParam(value="fechaInicio", required=true) String fechaInicio,
            @RequestParam(value="fechaFin", required=true) String fechaFin,
            @RequestParam(value="numFactura", required = true) String numFactura,
            ModelMap model) {
        try {
            Optional<Factura> factura = facturaService.findFacturaById(numFactura);
            Timestamp timestampInicio = convertStringToTimestamp(fechaInicio);
            Timestamp timestampFinal = convertStringToTimestamp(fechaFin);

            if (factura != null && factura.isPresent()) {
                Membresia membresia = new Membresia(timestampInicio,timestampFinal,factura.get());
                saveMembresia(membresia);
                model.addAttribute("membresia",membresia);
                return "tables/layout-table";
            } else {
                model.addAttribute("error","FACTURA ID SELECTED DOESNT EXIST");
                return "links";
            }
        } catch (Exception e) {
            model.addAttribute("error",e);
            return "links";
        }
    }

    static Timestamp convertStringToTimestamp(String strDate) {
        strDate = strDate.replace("T"," ");
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return Optional.of(strDate) //
                .map(str -> LocalDateTime.parse(str, formatter))
                .map(Timestamp::valueOf) //
                .orElse(null);
    }


    // http://localhost:8888/membresia/update (UPDATE FACTURA)
    @RequestMapping(value = "/membresia/update",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public String membresiaupdate(
            @RequestParam(value="idMembresia", required=true) String idMembresia,
            @RequestParam(value="fechaInicio", required=true) String fechaInicio,
            @RequestParam(value="fechaFin", required=true) String fechaFin,
            @RequestParam(value="numFactura", required = true) String numFactura,
            ModelMap model) {
        try {
            Optional<Factura> factura = facturaService.findFacturaById(numFactura);
            if (factura != null && factura.isPresent()) {
                Membresia membresia = new Membresia(Integer.parseInt(idMembresia), Timestamp.valueOf(fechaInicio),Timestamp.valueOf(fechaFin),factura.get());
                updateMembresia(membresia);
                model.addAttribute("membresia",membresia);
                return "tables/layout-table";
            } else {
                model.addAttribute("error","THE ID FOR FACTURA IS NOT CREATED YET");
                return "links";
            }
        } catch (Exception e) {
            model.addAttribute("error",e);
            return "links";
        }
    }

    // http://localhost:8888/membresia/delete/{id} (DELETE ID)
    @RequestMapping(value = "/membresia/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public String membresiadelete(@PathVariable int id, ModelMap model) {
        Optional<Membresia> membresia =  membresiaService.findMembresiaById(id);
        if (membresia.isPresent()) {
            model.addAttribute("membresia",membresia.get());
            deleteMembresiaById(id);
            return "tables/layout-table";
        } else {
            model.addAttribute("error","MEMBRESIA NOT FOUNDED");
            return "links";
        }
    }

    /* ------------------------------------------ */


    // http://localhost:8888/membresias (SHOW ALL)
    @RequestMapping(value = "/membresias",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @Override
    public String getAllMembresia(ModelMap model) {
        model.addAttribute("membresias",membresiaService.findAllMembresia());
        return "tables/layout-table";
    }

    // http://localhost:8888/membresia/1 (SHOW ONE)
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
