package com.example.crudspringbootweb.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Localidad")
public class Localidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLocalidad")
    private int idLocalidad;

    @Column(name = "nombreLocalidad")
    private String nombreLocalidad;

    @Column(name = "codigoPostal")
    private int codigoPostal;

    public Localidad(int idLocalidad, String nombreLocalidad, int codigoPostal) {
        this.idLocalidad = idLocalidad;
        this.nombreLocalidad = nombreLocalidad;
        this.codigoPostal = codigoPostal;
    }

    public Localidad() {

    }
}
