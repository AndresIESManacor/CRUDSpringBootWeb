package com.example.crudspringbootweb.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "localidad")
public class Localidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_localidad")
    private int id_localidad;

    @Column(name = "nombre_localidad")
    private String nombre_localidad;

    @Column(name = "codigo_postal")
    private int codigo_postal;

    public Localidad(int id_localidad, String nombre_localidad, int codigo_postal) {
        this.id_localidad = id_localidad;
        this.nombre_localidad = nombre_localidad;
        this.codigo_postal = codigo_postal;
    }

    public Localidad() {

    }
}
