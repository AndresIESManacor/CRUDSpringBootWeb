package com.example.crudspringbootweb.repository.Restaurante;

import com.example.crudspringbootweb.entity.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembresiaRepository extends JpaRepository<Membresia, Integer> {
    Void save(Optional<MembresiaRepository> membresiaOptional);
}
