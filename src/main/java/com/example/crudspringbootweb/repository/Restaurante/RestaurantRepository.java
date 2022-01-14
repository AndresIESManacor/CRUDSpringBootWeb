package com.example.crudspringbootweb.repository.Restaurante;

import com.example.crudspringbootweb.entity.Membresia;
import com.example.crudspringbootweb.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{
    Void save(Optional<Restaurant> customerToUpdate);

    //IS VALIDATED BOOLEAN
    @Query(value = "SELECT * FROM restaurante WHERE validated = ?1",nativeQuery = true)
    List<Membresia> findRestaurantByValidated(boolean validated);

    //IS VISIBLE BOOLEAN
    @Query(value = "SELECT * FROM restaurante WHERE visible = ?1",nativeQuery = true)
    List<Membresia> findRestaurantByVisible(boolean visible);

    //IS RESTAURANT NAME CHECK
    @Query(value = "SELECT * FROM restaurante WHERE nombre = ?1",nativeQuery = true)
    List<Membresia> findRestaurantByNombre(String nombre);

    //ID MEMBRESIA IS ALREADY VINCULADA
    @Query(value = "SELECT * FROM restaurante WHERE id_membresia = ?1",nativeQuery = true)
    List<Membresia> findRestaurantById_Membresia(int id_membresia);



}
