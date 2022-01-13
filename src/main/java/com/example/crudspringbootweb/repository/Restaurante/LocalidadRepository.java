package com.example.crudspringbootweb.repository.Restaurante;

import com.example.crudspringbootweb.entity.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalidadRepository extends JpaRepository<Localidad,Integer> {
    Void save(Optional<Localidad> localidadOptional);
}
