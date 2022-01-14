package com.example.crudspringbootweb.service;

import com.example.crudspringbootweb.entity.Localidad;

import java.util.List;
import java.util.Optional;

public interface LocalidadService {
    public List<Localidad> findAllLocalidad();

    public Optional<Localidad> findLocalidadById(int id);

    public Localidad saveLocalidad(Localidad localidadNew);

    public String deleteLocalidad(int id);

    public String updateLocalidad(Localidad localidad);

    // QUERY

    public List<Localidad> findLocalidadByNombre_localidad(String nombre);
}
