package com.example.crudspringbootweb.controllersImpl;

import com.example.crudspringbootweb.service.RestaurantService;
import com.example.crudspringbootweb.service.UseracountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    RestaurantService restaurantService;

    @Autowired
    UseracountService useracountService;

    //MY ROUTES

    //////////////         USER         ////////////////////

    // http://localhost:8888/userC (CREATE USER)
    @RequestMapping(value = "/userC", method = RequestMethod.GET)
    public String userC() {
        return "formularis/useracount/userAdd";
    }

    // http://localhost:8888/userU (UPDATE USER)
    @RequestMapping(value = "/userU", method = RequestMethod.GET)
    public String userU() {
        return "formularis/useracount/userUpdate";
    }

    /* ------------------------------------------ */

    //////////////         FACTURAS         ////////////////////

    // http://localhost:8888/facturaC (CREATE FACTURA)
    @RequestMapping(value = "/facturaC", method = RequestMethod.GET)
    public String facturaC() {
        return "formularis/factura/facturaAdd";
    }

    // http://localhost:8888/facturaU (UPDATE FACTURA)
    @RequestMapping(value = "/facturaU", method = RequestMethod.GET)
    public String facturaU() {
        return "formularis/factura/facturaUpdate";
    }

    /* ------------------------------------------ */


    //////////////         LOCALIZACION         ////////////////////

    // http://localhost:8888/localidadC (CREATE FACTURA)
    @RequestMapping(value = "/localidadC", method = RequestMethod.GET)
    public String localidadC() {
        return "formularis/localizacion/localizacionAdd";
    }

    // http://localhost:8888/localidadU (UPDATE FACTURA)
    @RequestMapping(value = "/localidadU", method = RequestMethod.GET)
    public String localidadU() {
        return "formularis/localizacion/localizacionUpdate";
    }

    /* ------------------------------------------ */


    //////////////         MEMBRESIA         ////////////////////

    // http://localhost:8888/membresiaC (CREATE MEMBRESIA)
    @RequestMapping(value = "/membresiaC", method = RequestMethod.GET)
    public String membresiaC() {
        return "formularis/membresia/membresiaAdd";
    }

    // http://localhost:8888/membresiaU (UPDATE MEMBRESIA)
    @RequestMapping(value = "/membresiaU", method = RequestMethod.GET)
    public String membresiaU() {
        return "formularis/membresia/membresiaUpdate";
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


    // http://localhost:8888/ (SHOW All Forms)
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public String getAllForms(){
        return "links";
    }
}
