package com.example.crudspringbootweb.service;

import com.example.crudspringbootweb.entity.Membresia;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface MembresiaService {
    public List<Membresia> findAllMembresia();

    public Optional<Membresia> findMembresiaById(BigInteger id);

    public Membresia saveMembresia(Membresia membresiaNew);

    public String deleteMembresia(BigInteger id);

    public String updateMembresia(Membresia membresia);

    // QUERY

    public List<Membresia> findMembresiaByNum_Factura(String num_factura);
}
