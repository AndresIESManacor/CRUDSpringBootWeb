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
import org.springframework.web.servlet.view.RedirectView;

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


    //////////////         RESTAURANTES   FORMULARIOS      ////////////////////

    @RequestMapping(value = "/restaurant/create", method = RequestMethod.GET)
    public String create(ModelMap model) {
        model.addAttribute("type","restaurant-create");
        model.addAttribute("object",new Restaurant());
        return "formularis/layout-form";
    }

    @RequestMapping(value = "/restaurant/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, ModelMap model) {
        Optional<Restaurant> restaurant = restaurantService.findRestaurantById(id);
        if (restaurant.isPresent()) {
            model.addAttribute("type","restaurant-update");
            model.addAttribute("object",restaurant.get());
            return "formularis/layout-form";
        }
        model.addAttribute("error","RESTAURANT SELECTED DOESNT PRESENT");
        return "links";
    }


    //////////////         RESTAURANTES   ACTIONS      ////////////////////

    @RequestMapping(value = "/restaurant/save")
    public String save(@ModelAttribute Restaurant restaurant, ModelMap model) {
        inicializeModelMap(model);
        String validation = validateRestaurant(restaurant);
        if (!validation.equals("OK")) {
            model.addAttribute("error",validation);
            return "links";
        }
        saveRestaurant(restaurant);
        return show(model);
    }

    @RequestMapping(value = "/restaurant/put")
    public String put(@ModelAttribute Restaurant restaurant, ModelMap model) {
        inicializeModelMap(model);
        String validation = validateRestaurant(restaurant);
        if (!validation.equals("OK")) {
            model.addAttribute("error",validation);
            return "links";
        }
        updateRestaurant(restaurant);
        return show(model);
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET, produces = "application/json")
    @Override
    public String show(ModelMap model) {
        model.addAttribute("restaurants",restaurantService.findAllRestaurants());
        return "tables/layout-table";
    }

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

    /* ------------------------------------------ */

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        restaurantService.saveRestaurant(restaurant);
    }

    @RequestMapping(value = "/restaurant/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public RedirectView delete(@PathVariable int id, ModelMap model) {
        Optional<Localidad> localidad =  localidadService.findLocalidadById(id);
        if (localidad.isPresent()) {
            restaurantService.deleteRestaurant(id);
        } else {
            model.addAttribute("error","LOCALIDAD NOT FOUNDED");
        }
        return new RedirectView("/restaurants");
    }

    @Override
    public String updateRestaurant(Restaurant restaurantNew) {
        return restaurantService.updateRestaurant(restaurantNew);
    }

    public String validateRestaurant(Restaurant restaurant) {
        Optional<Localidad> localidad = localidadService.findLocalidadById(restaurant.getLocalidad().getId_localidad());
        Optional<Membresia> membresia = membresiaService.findMembresiaById(restaurant.getMembresia().getId_membresia());
        Optional<Useracount> useracount = useracountService.findUseracountById(restaurant.getUseracount().getId_user());

        if (localidad.isEmpty()) {
            return "LOCALIDAD IS NOT PRESENT";
        }
        if (membresia.isEmpty()) {
            return "MEMBRESIA IS NOT PRESENT";
        }
        if (useracount.isEmpty()) {
            return "USERACOUNT IS NOT PRESENT";
        }
        return "OK";
    }

    public void inicializeModelMap(ModelMap model) {
        model.remove("restaurant");
        model.remove("restaurants");
        model.remove("error");
    }
}
