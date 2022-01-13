package com.example.crudspringbootweb.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="restaurante")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_restaurante")
    private int id_restaurante;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "dies_anticipacion_reservas")
    private int dies_anticipacion_reservas;

    @Column(name = "telefono_restaurante")
    private long telefono_restaurante;

    @Column(name = "validated")
    private boolean validated;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_membresia")
    private Membresia membresia;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_user")
    private Useracount useracount;

    @Column(name = "visible")
    private boolean visible;

    public Restaurant() {

    }

    public Restaurant(int id_restaurante, String nombre, int dies_anticipacion_reservas, long telefono_restaurante, boolean validated, Localidad localidad, Membresia membresia, Useracount user, boolean visible) {
        this.id_restaurante = id_restaurante;
        this.nombre = nombre;
        this.dies_anticipacion_reservas = dies_anticipacion_reservas;
        this.telefono_restaurante = telefono_restaurante;
        this.validated = validated;
        this.localidad = localidad;
        this.membresia = membresia;
        this.useracount = user;
        this.visible = visible;
    }

    public Restaurant(String nombre, int dies_anticipacion_reservas, long telefono_restaurante, boolean validated, Localidad localidad, Membresia membresia, Useracount user, boolean visible) {
        this.nombre = nombre;
        this.dies_anticipacion_reservas = dies_anticipacion_reservas;
        this.telefono_restaurante = telefono_restaurante;
        this.validated = validated;
        this.localidad = localidad;
        this.membresia = membresia;
        this.useracount = user;
        this.visible = visible;
    }
}
