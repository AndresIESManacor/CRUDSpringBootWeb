package com.example.crudspringbootweb.repository.Restaurante;

import com.example.crudspringbootweb.entity.Useracount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UseracountRepository extends JpaRepository<Useracount, Integer> {
    Void save(Optional<Useracount> useracountOptional);
}
