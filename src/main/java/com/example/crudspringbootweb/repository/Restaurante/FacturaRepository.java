package com.example.crudspringbootweb.repository.Restaurante;

import com.example.crudspringbootweb.entity.Factura;
import com.example.crudspringbootweb.entity.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FacturaRepository extends JpaRepository<Factura,String> {
    Void save(Optional<FacturaRepository> factura);
}
