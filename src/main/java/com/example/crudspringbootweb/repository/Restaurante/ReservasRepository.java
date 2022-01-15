package com.example.crudspringbootweb.repository.Restaurante;

import com.example.crudspringbootweb.entity.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ReservasRepository extends JpaRepository<Reservas, BigInteger> {
}
