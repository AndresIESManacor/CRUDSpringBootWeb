package com.example.crudspringbootweb.controllersImpl;

import com.example.crudspringbootweb.entity.Factura;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class GeneralController {

    // http://localhost:8888/ (SHOW All Forms)
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public String getAllForms(ModelMap model){
        return "links";
    }


    /* ------------------------------------------ */


    //////////////         RESTAURANTES         ////////////////////

    // http://localhost:8888/restauranteC (CREATE MEMBRESIA)
    @RequestMapping(value = "/restaurantC", method = RequestMethod.GET)
    public String restauranteC() {
        return "formularis/restaurant/restauranteAdd";
    }

    // http://localhost:8888/restauranteU (UPDATE MEMBRESIA)
    @RequestMapping(value = "/restaurantU", method = RequestMethod.GET)
    public String restauranteU() {
        return "formularis/restaurant/restauranteUpdate";
    }

    /* ------------------------------------------ */


    //////////////         IMAGENES         ////////////////////

    // http://localhost:8888/imagenC (CREATE MEMBRESIA)
//    @RequestMapping(value = "/imagenC", method = RequestMethod.GET)
//    public String imagenC() {
//        return "formularis/restaurant/restauranteAdd";
//    }

    // http://localhost:8888/imagenU (UPDATE MEMBRESIA)
//    @RequestMapping(value = "/imagenU", method = RequestMethod.GET)
//    public String imagenU() {
//        return "formularis/restaurant/restauranteUpdate";
//    }

    /* ------------------------------------------ */


}
