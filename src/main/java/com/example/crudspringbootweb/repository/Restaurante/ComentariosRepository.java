package com.example.crudspringbootweb.repository.Restaurante;

import com.example.crudspringbootweb.entity.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ComentariosRepository extends JpaRepository<Comentarios, BigInteger> {
}
