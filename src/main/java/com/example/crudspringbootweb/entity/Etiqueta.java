package com.example.crudspringbootweb.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Etiquetas")
public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEtiqueta")
    int idEtiquetas;

    @Column(name="nombre")
    String nombre;

    public Etiqueta(int idEtiquetas, String nombre) {
        this.idEtiquetas = idEtiquetas;
        this.nombre = nombre;
    }
    public Etiqueta(String nombre) {
        this.nombre = nombre;
    }
    public Etiqueta() {}
}
