package com.example.crudspringbootweb.controllers;

import com.example.crudspringbootweb.entity.Restaurant;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

public interface RestaurantControllers {
    public String show(ModelMap model);

    public String getRestaurantById(int id, ModelMap model);

    public void saveRestaurant(Restaurant restaurant);

    public RedirectView delete(int id, ModelMap model);

    public String updateRestaurant(Restaurant restaurantNew);
}
