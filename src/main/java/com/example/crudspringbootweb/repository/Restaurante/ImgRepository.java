package com.example.crudspringbootweb.repository.Restaurante;

import com.example.crudspringbootweb.entity.Img;
import com.example.crudspringbootweb.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface ImgRepository extends JpaRepository<Img, BigInteger> {
    @Query(value = "SELECT * FROM img WHERE url = ?1",nativeQuery = true)
    List<Img> findImgByUrl(String name);
}
