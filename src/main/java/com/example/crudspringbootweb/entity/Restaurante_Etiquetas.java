package com.example.crudspringbootweb.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "restaurante_etiquetas")
public class Restaurante_Etiquetas implements Serializable {
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_restaurante")
    @NotNull(message = "id_restaurante cant be null")
    private Restaurant restaurant;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_etiqueta")
    @NotNull(message = "id_etiqueta cant be null")
    private Etiquetas etiqueta;

    public Restaurante_Etiquetas(Restaurant restaurant, Etiquetas etiqueta) {
        this.restaurant = restaurant;
        this.etiqueta = etiqueta;
    }
    public Restaurante_Etiquetas(){}
}
