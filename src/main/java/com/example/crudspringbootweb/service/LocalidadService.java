package com.example.crudspringbootweb.service;

import com.example.crudspringbootweb.entity.Localidad;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface LocalidadService {
    public List<Localidad> findAllLocalidad();

    public Optional<Localidad> findLocalidadById(BigInteger id);

    public Localidad saveLocalidad(Localidad localidadNew);

    public void deleteLocalidad(BigInteger id);

    public void updateLocalidad(Localidad localidad);

    // QUERY

    public List<Localidad> findLocalidadByNombre_localidad(String nombre);
}
