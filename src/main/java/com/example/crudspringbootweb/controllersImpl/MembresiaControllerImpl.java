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
        model.addAttribute("object",null);
        model.addAttribute("array",facturaService.findAllFactura());
        return "formularis/layout-form";
    }

    @RequestMapping(value = "/membresia/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, ModelMap model) {
        Optional<Membresia> membresia = membresiaService.findMembresiaById(id);
        if (membresia.isPresent()) {
            model.addAttribute("type","membresia-update");
            model.addAttribute("object",membresia.get());
            model.addAttribute("array",facturaService.findAllFactura());
            return "formularis/layout-form";
        }
        model.addAttribute("error","MEMBRESIA SELECTED DOESNT PRESENT");
        return "links";
    }

    //////////////         MEMBRESIA ACTIONS        ////////////////////

    @RequestMapping(value = "/membresia/save",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public String save(
            @RequestParam(value="fecha_inicio", required=true) String fecha_inicio,
            @RequestParam(value="fecha_fin", required=true) String fecha_fin,
            @RequestParam(value="num_factura", required=true) String num_factura,
            ModelMap model) {
        inicializeModelMap(model);
        Optional<Factura> factura = facturaService.findFacturaById(num_factura);
        if (factura.isPresent()) {
            if (checkNum_Factura(factura.get().getNum_factura())) {
                model.addAttribute("error","factura relation is already done");
            } else {
                saveMembresia(new Membresia(fecha_inicio, fecha_fin, factura.get()));
            }
        } else {
            model.addAttribute("error","FACTURA NOT FOUND");
        }
        return show(model);
    }


    @RequestMapping(value = "/membresia/put",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public String put(
            @RequestParam(value="id_membresia", required=true) int id_membresia,
            @RequestParam(value="fecha_inicio", required=true) String fecha_inicio,
            @RequestParam(value="fecha_fin", required=true) String fecha_fin,
            @RequestParam(value="num_factura", required=true) String num_factura,
            ModelMap model) {
        inicializeModelMap(model);
        Optional<Membresia> membresia = membresiaService.findMembresiaById(id_membresia);
        Optional<Factura> factura = facturaService.findFacturaById(num_factura);
        if (factura.isPresent()) {
            Membresia membresiaUpdated = new Membresia(id_membresia, fecha_inicio, fecha_fin,factura.get());
            if (membresia.isPresent()) {
                if (membresia.get().getFactura().getNum_factura().equals(membresiaUpdated.getFactura().getNum_factura())) {
                    updateMembresia(membresiaUpdated);
                } else if (membresiaService.findMembresiaByNum_Factura(factura.get().getNum_factura()).isEmpty()) {
                    updateMembresia(membresiaUpdated);
                } else {
                    model.addAttribute("error","factura is already vinculada");
                }
            } else {
                model.addAttribute("error","membresia is not present");
            }
        } else {
            model.addAttribute("error","factura is not present");
        }
        return show(model);
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
    public String show(ModelMap model) {
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
    public void saveMembresia(Membresia membresia) {
        if (membresia!=null) {
            membresiaService.saveMembresia(membresia);
        }
    }

    @Override
    public String deleteMembresiaById(int id) {
        return membresiaService.deleteMembresia(id);
    }


    public boolean checkNum_Factura(String num_factura) {
        return !membresiaService.findMembresiaByNum_Factura(num_factura).isEmpty();
    }

    @Override
    public String updateMembresia(Membresia membresiaNew) {
        return membresiaService.updateMembresia(membresiaNew);
    }

    public void inicializeModelMap(ModelMap model) {
        model.remove("membresia");
        model.remove("membresias");
        model.remove("error");
    }
}
