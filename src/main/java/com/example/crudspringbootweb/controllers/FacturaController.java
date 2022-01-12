package com.example.crudspringbootweb.controllers;

import com.example.crudspringbootweb.entity.Factura;
import com.example.crudspringbootweb.entity.Useracount;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;

public interface FacturaController {
    public String getAllFactura(ModelMap model);

    public String findFacturaById(String id, ModelMap model);

    public Factura saveFactura(Factura factura);

    public void deleteFacturaById(String id);

    public void updateFactura(Factura facturaNew);
}
