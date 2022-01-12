package com.example.crudspringbootweb.controllersImpl;

import com.example.crudspringbootweb.controllers.UseracountController;
import com.example.crudspringbootweb.entity.Localidad;
import com.example.crudspringbootweb.entity.Useracount;
import com.example.crudspringbootweb.service.UseracountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UseracountControllerImpl implements UseracountController {

    @Autowired
    UseracountService useracountService;


    // http://localhost:8888/user/add (CREATE USER)
    @RequestMapping(value = "/user/add",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public String useradd(
            @RequestParam(value="nombreUsuario", required=true) String nombre,
            @RequestParam(value="contraseña", required=true) String password,
            @RequestParam(value="correo", required=true) String correo,
            @RequestParam(value="telefono", required=true) String telefono,
            @RequestParam(value="nombreUser", required=true) String nombreUser,
            @RequestParam(value="apellido1", required=true) String apellido1,
            @RequestParam(value="apellido2", required=true) String apellido2,
            @RequestParam(value="dni", required=true) String dni,
            @RequestParam(value = "isAdmin", required = false) boolean isAdmin,
            ModelMap model) {
        try {
            Useracount useracount = new Useracount(nombre,password,correo,Long.parseLong(telefono),nombreUser,apellido1,apellido2,dni,isAdmin);
            useracountService.saveUseracount(useracount);
            model.addAttribute("useracounts",useracountService.findAllUseracount());
            return "tables/layout-table";
        } catch (Exception e) {
            model.addAttribute("error",e);
            return "links";
        }
    }


    // http://localhost:8888/user/add (UPDATE USER)
    @RequestMapping(value = "/user/update",method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public String userupdate(
            @RequestParam(value="idUser", required=true) String idUser,
            @RequestParam(value="nombreUsuario", required=true) String nombre,
            @RequestParam(value="contraseña", required=true) String password,
            @RequestParam(value="correo", required=true) String correo,
            @RequestParam(value="telefono", required=true) String telefono,
            @RequestParam(value="nombreUser", required=true) String nombreUser,
            @RequestParam(value="apellido1", required=true) String apellido1,
            @RequestParam(value="apellido2", required=true) String apellido2,
            @RequestParam(value="dni", required=true) String dni,
            @RequestParam(value = "isAdmin", required = false) boolean isAdmin,
            ModelMap model) {
        try {
            Useracount useracount = new Useracount(Integer.parseInt(idUser),nombre,password,correo,Long.parseLong(telefono), nombreUser, apellido1, apellido2, dni, isAdmin);
            updateUseracount(useracount);
            model.addAttribute("useracounts",useracountService.findAllUseracount());
            return "tables/layout-table";
        } catch (Exception e) {
            model.addAttribute("error",e);
            return "links";
        }
    }

    // http://localhost:8888/user/delete/{id} (DELETE ID)
    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public String userdelete(@PathVariable int id, ModelMap model) {
        Optional<Useracount> useracount =  useracountService.findUseracountById(id);
        if (useracount.isPresent()) {
            model.addAttribute("useracount",useracount.get());
            deleteUseracount(id);
            return "tables/layout-table";
        } else {
            model.addAttribute("error","LOCALIDAD NOT FOUNDED");
            return "links";
        }
    }
    /* ------------------------------------------ */

    // http://localhost:8888/users (SHOW ALL)
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    @Override
    public String getAllUseracount(ModelMap model) {
        model.addAttribute("useracounts",useracountService.findAllUseracount());
        return "tables/layout-table";
    }

    // http://localhost:8888/user/1 (SHOW ID)
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

    @Override
    public Useracount addUseracount(Useracount useracount) {
        if (useracount != null) {
            useracountService.saveUseracount(useracount);
        }
        return null;
    }

    @Override
    public String deleteUseracount(@PathVariable int id) {
        return useracountService.deleteUseracount(id);
    }

    @Override
    public String updateUseracount(Useracount useracountNew) {
        return useracountService.updateUseracount(useracountNew);
    }
}
