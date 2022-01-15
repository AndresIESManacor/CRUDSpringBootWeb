package com.example.crudspringbootweb.repository.Restaurante;

import com.example.crudspringbootweb.entity.Etiquetas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface EtiquetasRepository extends JpaRepository<Etiquetas, BigInteger> {
}
