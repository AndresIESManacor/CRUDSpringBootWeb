package com.example.crudspringbootweb.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Restaurante_EtiquetasId implements Serializable {
    private Restaurant restaurant;
    private Etiquetas etiquetas;

    public Restaurante_EtiquetasId (Restaurant restaurant, Etiquetas etiquetas) {
        this.restaurant = restaurant;
        this.etiquetas = etiquetas;
    }
    public Restaurante_EtiquetasId(){}
}
