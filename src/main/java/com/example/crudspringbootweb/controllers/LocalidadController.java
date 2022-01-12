package com.example.crudspringbootweb.controllers;

import com.example.crudspringbootweb.entity.Localidad;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;

public interface LocalidadController {
    public String getAllLocalidad(ModelMap model);

    public String findLocalidadById(int id, ModelMap model);

    public Localidad saveLocalidad(Localidad localidad);

    public String deleteLocalidadById(int id);

    public String updateLocalidad(Localidad localidadNew);
}
