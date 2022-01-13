package com.example.crudspringbootweb.repository.Restaurante;

import com.example.crudspringbootweb.entity.Membresia;
import com.example.crudspringbootweb.entity.Useracount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MembresiaRepository extends JpaRepository<Membresia, Integer> {
    Void save(Optional<MembresiaRepository> membresiaOptional);

    @Query(value = "SELECT * FROM membresia WHERE num_factura = ?1",nativeQuery = true)
    List<Membresia> findMembresiaByNum_Factura(String num_factura);
}
