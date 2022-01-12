package com.example.crudspringbootweb.service;

import com.example.crudspringbootweb.entity.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    public List<Restaurant> findAllRestaurants();

    public Optional<Restaurant> findRestaurantById(int id);

    public Restaurant saveRestaurant(Restaurant restaurantNew);

    public String deleteRestaurant(int id);

    public String updateRestaurant(Restaurant restaurantNew);
}
