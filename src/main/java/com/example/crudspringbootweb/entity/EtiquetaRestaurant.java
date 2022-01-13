package com.example.crudspringbootweb.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "RestauranteEtiquetas")
public class EtiquetaRestaurant implements Serializable {
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "idRestaurante")
    private Restaurant restaurant;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "idEtiqueta")
    private Etiqueta etiqueta;

    public EtiquetaRestaurant(Restaurant restaurant, Etiqueta etiqueta) {
        this.restaurant = restaurant;
        this.etiqueta = etiqueta;
    }
    public EtiquetaRestaurant(){}
}
