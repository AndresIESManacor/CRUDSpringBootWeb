package com.example.crudspringbootweb.controllersImpl;

import com.example.crudspringbootweb.entity.Localidad;
import com.example.crudspringbootweb.entity.Membresia;
import com.example.crudspringbootweb.entity.Restaurant;
import com.example.crudspringbootweb.entity.Useracount;
import com.example.crudspringbootweb.service.LocalidadService;
import com.example.crudspringbootweb.service.MembresiaService;
import com.example.crudspringbootweb.service.RestaurantService;
import com.example.crudspringbootweb.service.UseracountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.example.crudspringbootweb.controllers.RestaurantControllers;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Controller
public class RestaurantControllerImpl implements RestaurantControllers {
    @Autowired
    RestaurantService restaurantService;

    @Autowired
    UseracountService useracountService;

    @Autowired
    MembresiaService membresiaService;

    @Autowired
    LocalidadService localidadService;

    // http://localhost:8888/restaurant/add (METHOD CREATE)
    @RequestMapping(value = "/restaurant/add")
    public String postRestaurant(
            @RequestParam(value="nombre", required=true) String nombre,
            @RequestParam(value="diesAnticipacionReservas", required=true) String diesAnticipacionReservas,
            @RequestParam(value="telefonoRestaurante", required=true) String telefonoRestaurante,
            @RequestParam(value="isValidated", required=true) boolean isValidated,
            @RequestParam(value="visible", required=true) boolean visible,
            @RequestParam(value="idLocalidad", required=true) String idLocalidad,
            @RequestParam(value="idMembresia", required=true) String idMembresia,
            @RequestParam(value="idUser", required=true) String idUser,
            ModelMap model) {
        String validation = validateRestaurant(nombre, Integer.parseInt(diesAnticipacionReservas), Long.parseLong(telefonoRestaurante), isValidated, visible, idLocalidad, idMembresia, idUser,"create");
        if (!validation.equals("OK")) {
            model.addAttribute("error",validation);
            return "links";
        }
        model.addAttribute("restaurants",restaurantService.findAllRestaurants());
        return "tables/layout-table";
    }

    // http://localhost:8888/restaurant/add (METHOD CREATE)
    @RequestMapping(value = "/restaurant/update")
    public String updateRestaurant(
            @RequestParam(value="nombre", required=true) String nombre,
            @RequestParam(value="diesAnticipacionReservas", required=true) String diesAnticipacionReservas,
           @RequestParam(value="telefonoRestaurante", required=true) String telefonoRestaurante,
            @RequestParam(value="isValidated", required=true) boolean isValidated,
            @RequestParam(value="visible", required=true) boolean visible,
            @RequestParam(value="idLocalidad", required=true) String idLocalidad,
            @RequestParam(value="idMembresia", required=true) String idMembresia,
            @RequestParam(value="idUser", required=true) String idUser,
            ModelMap model) {

        String validation = validateRestaurant(nombre, Integer.parseInt(diesAnticipacionReservas), Long.parseLong(telefonoRestaurante), isValidated, visible, idLocalidad, idMembresia, idUser,"update");
        if (!validation.equals("OK")) {
            model.addAttribute("error",validation);
            return "links";
        }
        model.addAttribute("restaurants",restaurantService.findAllRestaurants());
        return "tables/layout-table";
    }

    // http://localhost:8888/restaurants (SHOW ALL)
    @RequestMapping(value = "/restaurants", method = RequestMethod.GET, produces = "application/json")
    @Override
    public String getAllRestaurant(ModelMap model) {
        model.addAttribute("restaurants",restaurantService.findAllRestaurants());
        return "tables/layout-table";
    }

    // http://localhost:8888/restaurant/1 (SHOW)
    @RequestMapping(value = "/restaurant/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public String getRestaurantById(@PathVariable int id, ModelMap model) {
        Optional<Restaurant> restaurant = restaurantService.findRestaurantById(id);
        if (restaurant.isPresent()) {
            model.addAttribute("restaurant",restaurant.get());
            return "tables/layout-table";
        }
        model.addAttribute("error","RESTAURANT NOT FOUNDED");
        return "links";
    }



    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantService.saveRestaurant(restaurant);
    }

    // http://localhost:8888/restaurant/delete/1 (DELETE)
    @RequestMapping(value = "/restaurant/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public String deleteRestaurant(@PathVariable int id) {
        return restaurantService.deleteRestaurant(id);
    }

    @Override
    public String updateRestaurant(Restaurant restaurantNew) {
        return restaurantService.updateRestaurant(restaurantNew);
    }

    public String validateRestaurant(String nombre,Integer diesAnticipacionReservas, long telefonoRestaurante, boolean isValidated, boolean visible, String idLocalidad, String idMembresia, String idUser, String request) {
        Optional<Localidad> localidad = localidadService.findLocalidadById(Integer.parseInt(idLocalidad));
        Optional<Membresia> membresia = membresiaService.findMembresiaById(Integer.parseInt(idMembresia));
        Optional<Useracount> useracount = useracountService.findUseracountById(Integer.parseInt(idUser));

        if (localidad.isEmpty()) {
            return "LOCALIDAD IS NOT PRESENT";
        }
        if (membresia.isEmpty()) {
            return "MEMBRESIA IS NOT PRESENT";
        }
        if (useracount.isEmpty()) {
            return "USERACOUNT IS NOT PRESENT";
        }
        if (request.equals("update")) {
            Restaurant restaurant = new Restaurant(nombre, diesAnticipacionReservas, telefonoRestaurante, isValidated, localidad.get(), membresia.get(), useracount.get(), visible);
            updateRestaurant(restaurant);
        }
        if (request.equals("create")) {
            Restaurant restaurant = new Restaurant(nombre, diesAnticipacionReservas, telefonoRestaurante, isValidated, localidad.get(), membresia.get(), useracount.get(), visible);
            saveRestaurant(restaurant);
        }
        return "OK";
    }
}
