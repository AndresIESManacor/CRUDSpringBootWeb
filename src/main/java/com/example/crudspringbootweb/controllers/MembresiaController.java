package com.example.crudspringbootweb.controllers;

import com.example.crudspringbootweb.entity.Membresia;
import org.springframework.ui.ModelMap;

import java.math.BigInteger;

public interface MembresiaController {
    public String show(ModelMap model);

    public String findMembresiaById(BigInteger id, ModelMap model);

    public void saveMembresia(Membresia membresia);

    public void deleteMembresiaById(BigInteger id);

    public void updateMembresia(Membresia membresiaNew);
}