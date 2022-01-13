package com.example.crudspringbootweb.controllers;

import com.example.crudspringbootweb.entity.Membresia;
import org.springframework.ui.ModelMap;

public interface MembresiaController {
    public String show(ModelMap model);

    public String findMembresiaById(int id, ModelMap model);

    public void saveMembresia(Membresia membresia);

    public String deleteMembresiaById(int id);

    public String updateMembresia(Membresia membresiaNew);
}