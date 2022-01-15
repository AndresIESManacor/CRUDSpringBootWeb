package com.example.crudspringbootweb.service;

import com.example.crudspringbootweb.entity.Restaurante_Etiquetas;
import com.example.crudspringbootweb.entity.Restaurante_EtiquetasId;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface Restaurante_EtiquetasService {
    public List<Restaurante_Etiquetas> findAllRestaurante_Etiquetas();

    public Optional<Restaurante_Etiquetas> findRestaurante_EtiquetasById(Restaurante_EtiquetasId id);

    public Restaurante_Etiquetas saveRestaurante_Etiquetas(Restaurante_Etiquetas reservasNew);

    public void deleteRestaurante_Etiquetas(Restaurante_EtiquetasId id);

    public void updateRestaurante_Etiquetas(Restaurante_Etiquetas reservas);
}
