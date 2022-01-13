package com.example.crudspringbootweb.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "restaurante_etiquetas")
public class Restaurante_Etiquetas implements Serializable {
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_restaurante")
    private Restaurant restaurant;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_etiqueta")
    private Etiquetas etiqueta;

    public Restaurante_Etiquetas(Restaurant restaurant, Etiquetas etiqueta) {
        this.restaurant = restaurant;
        this.etiqueta = etiqueta;
    }
    public Restaurante_Etiquetas(){}
}
