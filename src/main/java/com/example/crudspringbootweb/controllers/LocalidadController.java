package com.example.crudspringbootweb.controllers;

import com.example.crudspringbootweb.entity.Localidad;
import org.springframework.ui.ModelMap;

public interface LocalidadController {
    public String show(ModelMap model);

    public String findLocalidadById(int id, ModelMap model);

    public void saveLocalidad(Localidad localidad);

    public String deleteLocalidadById(int id);

    public String updateLocalidad(Localidad localidadNew);
}
