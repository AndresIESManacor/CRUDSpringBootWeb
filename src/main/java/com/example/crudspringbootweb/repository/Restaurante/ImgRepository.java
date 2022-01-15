package com.example.crudspringbootweb.repository.Restaurante;

import com.example.crudspringbootweb.entity.Img;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ImgRepository extends JpaRepository<Img, BigInteger> {
}
