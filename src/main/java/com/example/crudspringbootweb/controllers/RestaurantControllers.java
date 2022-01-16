package com.example.crudspringbootweb.controllers;

import com.example.crudspringbootweb.entity.Restaurant;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigInteger;

public interface RestaurantControllers {
    public String show(ModelMap model);

    public String getRestaurantById(BigInteger id, ModelMap model);

    public void saveRestaurant(Restaurant restaurant);

    public RedirectView delete(BigInteger id, ModelMap model);

    public void updateRestaurant(Restaurant restaurantNew);
}
