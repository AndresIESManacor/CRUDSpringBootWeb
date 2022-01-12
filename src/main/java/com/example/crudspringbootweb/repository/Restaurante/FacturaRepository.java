package com.example.crudspringbootweb.repository.Restaurante;

import com.example.crudspringbootweb.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacturaRepository extends JpaRepository<Factura,String> {
    Void save(Optional<FacturaRepository> factura);
}
