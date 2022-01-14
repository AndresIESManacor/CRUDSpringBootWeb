package com.example.crudspringbootweb.controllers;

import com.example.crudspringbootweb.entity.Localidad;
import org.springframework.ui.ModelMap;

import java.math.BigInteger;

public interface LocalidadController {
    public String show(ModelMap model);

    public String findLocalidadById(BigInteger id, ModelMap model);

    public void saveLocalidad(Localidad localidad);

    public String deleteLocalidadById(BigInteger id);

    public String updateLocalidad(Localidad localidadNew);
}
