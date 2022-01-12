package com.example.crudspringbootweb.service;

import com.example.crudspringbootweb.entity.Factura;
import com.example.crudspringbootweb.repository.Restaurante.FacturaRepository;

import java.util.List;
import java.util.Optional;

public interface FacturaService {
    public List<Factura> findAllFactura();

    public Optional<Factura> findFacturaById(String id);

    public Factura saveFactura(Factura facturaNew);

    public String deleteFactura(String id);

    public String updateFactura(Factura factura);
}
