package com.example.crudspringbootweb.repository.Restaurante;

import com.example.crudspringbootweb.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{
    Void save(Optional<Restaurant> customerToUpdate);

    //IS VALIDATED BOOLEAN

    //IS RESTAURANT NAME CHECK

    //ID MEMBRESIA IS ALREADY VINCULADA

    //IS VISIBLE BOOLEAN

}
