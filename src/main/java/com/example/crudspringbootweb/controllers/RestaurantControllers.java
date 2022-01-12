package com.example.crudspringbootweb.controllers;

import com.example.crudspringbootweb.entity.Restaurant;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;

public interface RestaurantControllers {
    public String getAllRestaurant(ModelMap model);

    public String getRestaurantById(int id, ModelMap model);

    public Restaurant saveRestaurant(Restaurant restaurant);

    public String deleteRestaurant(int id);

    public String updateRestaurant(Restaurant restaurantNew);
}
