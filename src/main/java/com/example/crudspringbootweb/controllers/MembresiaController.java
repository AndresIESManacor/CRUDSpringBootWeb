package com.example.crudspringbootweb.controllers;

import com.example.crudspringbootweb.entity.Localidad;
import com.example.crudspringbootweb.entity.Membresia;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;

public interface MembresiaController {
    public String getAllMembresia(ModelMap model);

    public String findMembresiaById(int id, ModelMap model);

    public Membresia saveMembresia(Membresia membresia);

    public String deleteMembresiaById(int id);

    public String updateMembresia(Membresia membresiaNew);
}