package com.example.crudspringbootweb.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "etiquetas")
public class Etiquetas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_etiqueta")
    int id_etiqueta;

    @Column(name="nombre")
    String nombre;

    public Etiquetas(int id_etiqueta, String nombre) {
        this.id_etiqueta = id_etiqueta;
        this.nombre = nombre;
    }
    public Etiquetas(String nombre) {
        this.nombre = nombre;
    }
    public Etiquetas() {}
}
