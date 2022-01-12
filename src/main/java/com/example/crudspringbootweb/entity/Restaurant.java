package com.example.crudspringbootweb.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Restaurante")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRestaurante")
    private int idRestaurant;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "diesAnticipacionReservas")
    private int diesAnticipacionReservas;

    @Column(name = "telefonoRestaurante")
    private long telefonoRestaurante;

    @Column(name = "isValidated")
    private boolean isValidated;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "idLocalidad")
    private Localidad localidad;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "idMembresia")
    private Membresia membresia;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser")
    private Useracount useracount;

    @Column(name = "visible")
    private boolean visible;

    public Restaurant() {

    }

    public Restaurant(int idRestaurant, String nombre, int diesAnticipacionReservas, long telefonoRestaurante, boolean isValidated, Localidad localidad, Membresia membresia, Useracount user, boolean visible) {
        this.idRestaurant = idRestaurant;
        this.nombre = nombre;
        this.diesAnticipacionReservas = diesAnticipacionReservas;
        this.telefonoRestaurante = telefonoRestaurante;
        this.isValidated = isValidated;
        this.localidad = localidad;
        this.membresia = membresia;
        this.useracount = user;
        this.visible = visible;
    }

    public Restaurant(String nombre, int diesAnticipacionReservas, long telefonoRestaurante, boolean isValidated, Localidad localidad, Membresia membresia, Useracount user, boolean visible) {
        this.nombre = nombre;
        this.diesAnticipacionReservas = diesAnticipacionReservas;
        this.telefonoRestaurante = telefonoRestaurante;
        this.isValidated = isValidated;
        this.localidad = localidad;
        this.membresia = membresia;
        this.useracount = user;
        this.visible = visible;
    }
}
