package com.example.crudspringbootweb.service;

import com.example.crudspringbootweb.entity.Etiquetas;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface EtiquetasService {
    public List<Etiquetas> findAllEtiquetas();

    public Optional<Etiquetas> findEtiquetaById(BigInteger id);

    public Etiquetas saveEtiqueta(Etiquetas etiquetasNew);

    public void deleteEtiqueta(BigInteger id);

    public void updateEtiqueta(Etiquetas etiquetas);
}
