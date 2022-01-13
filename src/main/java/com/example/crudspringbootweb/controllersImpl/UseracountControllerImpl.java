package com.example.crudspringbootweb.controllersImpl;

import com.example.crudspringbootweb.controllers.UseracountController;
import com.example.crudspringbootweb.entity.Factura;
import com.example.crudspringbootweb.entity.Localidad;
import com.example.crudspringbootweb.entity.Membresia;
import com.example.crudspringbootweb.entity.Useracount;
import com.example.crudspringbootweb.service.UseracountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class UseracountControllerImpl implements UseracountController {

    @Autowired
    UseracountService useracountService;

    //////////////         USER         ////////////////////

    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public String create(ModelMap model) {
        model.addAttribute("type","useracount-create");
        model.addAttribute("object",new Useracount());
        return "formularis/layout-form";
    }

    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, ModelMap model) {
        Optional<Useracount> useracount = useracountService.findUseracountById(id);
        if (useracount.isPresent()) {
            model.addAttribute("type","useracount-update");
            model.addAttribute("object",useracount.get());
            return "formularis/layout-form";
        }
        model.addAttribute("error","MEMBRESIA SELECTED DOESNT PRESENT");
        return "links";
    }


    //////////////         USER ACTIONS        ////////////////////


    @RequestMapping(value = "/user/save",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public String save(@ModelAttribute Useracount useracount, ModelMap model) {
        inicializeModelMap(model);
        Optional<Useracount> requestUseracount = useracountService.findUseracountById(useracount.getIdUser());
        if (requestUseracount.isPresent()) {
            model.addAttribute("type","useracount-create");
            model.addAttribute("object",new Useracount());
            model.addAttribute("error","TRYING TO SAVE USERACOUNT THAT EXIST");
        } else {
            saveUseracount(useracount);
        }
        return getAllUseracount(model);
    }

    @RequestMapping(value = "/user/put",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public String put(@ModelAttribute Useracount useracount, ModelMap model) {
        inicializeModelMap(model);
        updateUseracount(useracount);
        return getAllUseracount(model);
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public RedirectView delete(@PathVariable int id, ModelMap model) {
        Optional<Useracount> useracount =  useracountService.findUseracountById(id);
        if (useracount.isPresent()) {
            deleteUseracountById(id);
        } else {
            model.addAttribute("error","USERACOUNT NOT FOUNDED");
        }
        return new RedirectView("/users");
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    @Override
    public String getAllUseracount(ModelMap model) {
        model.addAttribute("useracounts",useracountService.findAllUseracount());
        return "tables/layout-table";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public String getUseracountById(@PathVariable int id, ModelMap model) {
        Optional<Useracount> useracount = useracountService.findUseracountById(id);
        if (useracount.isPresent()) {
            model.addAttribute("useracount",useracount.get());
            return "tables/layout-table";
        }
        model.addAttribute("error","USERACOUNT NOT FOUNDED");
        return "links";
    }



    /* ------------------------------------------ */



    @Override
    public Useracount saveUseracount(Useracount useracount) {
        if (useracount != null) {
            useracountService.saveUseracount(useracount);
        }
        return null;
    }

    @Override
    public String deleteUseracountById(@PathVariable int id) {
        return useracountService.deleteUseracount(id);
    }

    @Override
    public String updateUseracount(Useracount useracountNew) {
        return useracountService.updateUseracount(useracountNew);
    }

    public void inicializeModelMap(ModelMap model) {
        model.remove("useracount");
        model.remove("useracounts");
        model.remove("error");
    }
}
