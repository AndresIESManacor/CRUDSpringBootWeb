package com.example.crudspringbootweb.service;

import com.example.crudspringbootweb.entity.Membresia;

import java.util.List;
import java.util.Optional;

public interface MembresiaService {
    public List<Membresia> findAllMembresia();

    public Optional<Membresia> findMembresiaById(int id);

    public Membresia saveMembresia(Membresia membresiaNew);

    public String deleteMembresia(int id);

    public String updateMembresia(Membresia membresia);
}
