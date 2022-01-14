package com.example.crudspringbootweb.controllersImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class GeneralController {

    // http://localhost:8888/ (SHOW All Forms)
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public String getAllForms(){
        return "principalPage";
    }
}
