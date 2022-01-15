package com.example.crudspringbootweb.controllers;

import com.example.crudspringbootweb.entity.Etiquetas;
import org.springframework.ui.ModelMap;

import java.math.BigInteger;

public interface EtiquetasController {
    public String show(ModelMap model);

    public String findEtiquetasById(BigInteger id, ModelMap model);

    public void saveEtiquetas(Etiquetas etiquetas);

    public void deleteEtiquetasById(BigInteger id);

    public void updateEtiquetas(Etiquetas etiquetasNew);
}
