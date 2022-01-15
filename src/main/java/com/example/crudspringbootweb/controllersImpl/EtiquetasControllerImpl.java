package com.example.crudspringbootweb.controllersImpl;

import com.example.crudspringbootweb.controllers.EtiquetasController;
import com.example.crudspringbootweb.entity.Etiquetas;
import com.example.crudspringbootweb.service.EtiquetasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.Optional;

@Controller
public class EtiquetasControllerImpl implements EtiquetasController {

    private final String __route_formularis = "formularis/layout-form";
    private final String __route_table = "tables/layout-table";
    private final String __route_home = "links";

    @Autowired
    EtiquetasService etiquetasService;

    //////////////         FACTURAS FORMULARIOS        ////////////////////

    @RequestMapping(value = "/etiqueta/create", method = RequestMethod.GET)
    public String create(ModelMap model) {
        model.addAttribute("type","etiquetas-create");
        model.addAttribute("object",new Etiquetas());
        return __route_formularis;
    }

    @RequestMapping(value = "/etiqueta/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable BigInteger id, ModelMap model) {
        if (id!=null) {
            Optional<Etiquetas> etiquetas = etiquetasService.findEtiquetaById(id);
            if (etiquetas.isPresent()) {
                model.addAttribute("type", "etiquetas-update");
                model.addAttribute("object", etiquetas.get());
                return __route_formularis;
            }
        }
        model.addAttribute("error","ETIQUETAS SELECTED DOESNT PRESENT");
        return __route_home;
    }

    //////////////         ROUTES        ////////////////////


    @RequestMapping(value = "/etiqueta/save",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public String save(@ModelAttribute @Valid Etiquetas etiquetas, BindingResult errors, ModelMap model) {
        inicializeModelMap(model);
        if (errors.hasErrors()) {
            return "redirect:/etiqueta/create";
        }

        if (etiquetas.getId_etiqueta()!=null) {
            Optional<Etiquetas> requestEtiqueta = etiquetasService.findEtiquetaById(etiquetas.getId_etiqueta());
            if (requestEtiqueta.isPresent()) {
                model.addAttribute("type","etiquetas-create");
                model.addAttribute("object",new Etiquetas());
                model.addAttribute("error","TRYING TO SAVE ETIQUETA THAT EXIST");
                return show(model);
            }
        }
        saveEtiquetas(etiquetas);
        return show(model);
    }


    @RequestMapping(value = "/etiqueta/put",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public String put(@ModelAttribute @Valid Etiquetas etiquetas, ModelMap model, Errors errors) {
        inicializeModelMap(model);
        if (errors.hasErrors()) {
            return "redirect:/etiquetas";
        }

        if (etiquetas.getId_etiqueta()!=null) {
            Optional<Etiquetas> etiquetasOptional = etiquetasService.findEtiquetaById(etiquetas.getId_etiqueta());
            if (etiquetasOptional.isPresent()) {
                if (etiquetas.getId_etiqueta().equals(etiquetasOptional.get().getId_etiqueta())) {
                    updateEtiquetas(etiquetas);
                } else {
                    model.addAttribute("error","factura id doesnt match with the actual factura id");
                }
            } else {
                model.addAttribute("error","factura id doesnt exit");
            }
        }
        return show(model);
    }

    @RequestMapping(value = "/etiqueta/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public RedirectView delete(@PathVariable BigInteger id, ModelMap model) {
        if (id!=null) {
            Optional<Etiquetas> etiquetas = etiquetasService.findEtiquetaById(id);
            if (etiquetas.isPresent()) {
                deleteEtiquetasById(id);
            } else {
                model.addAttribute("error", "ETIQUETAS NOT FOUNDED");
            }
        }
        return new RedirectView("/etiquetas");
    }

    @RequestMapping(value = "/etiquetas",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @Override
    public String show(ModelMap model) {
        model.addAttribute("etiquetas",etiquetasService.findAllEtiquetas());
        return __route_table;
    }

    @RequestMapping(value = "/etiqueta/{id}",method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @Override
    public String findEtiquetasById(@PathVariable BigInteger id, ModelMap model) {
        if (id!=null) {
            Optional<Etiquetas> etiquetas = etiquetasService.findEtiquetaById(id);
            if (etiquetas.isPresent()) {
                model.addAttribute("etiqueta", etiquetas.get());
                return __route_table;
            }
        }
        model.addAttribute("error","ETIQUETA NOT FOUNDED");
        return __route_home;
    }

    /* ------------------------------------------ */

    @Override
    public void saveEtiquetas(Etiquetas etiquetas) {
        etiquetasService.saveEtiqueta(etiquetas);
    }

    @Override
    public void deleteEtiquetasById(BigInteger id) {
        etiquetasService.deleteEtiqueta(id);
    }

    @Override
    public void updateEtiquetas(Etiquetas etiquetasNew) {
        etiquetasService.updateEtiqueta(etiquetasNew);
    }

    public void inicializeModelMap(ModelMap model) {
        model.remove("etiqueta");
        model.remove("etiquetas");
        model.remove("error");
    }
}
