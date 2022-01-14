package com.example.crudspringbootweb.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name="restaurante")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_restaurante")
    @NotNull(message = "id_restaurante cant be null")
    @Min(0)
    private int id_restaurante;

    @Column(name = "nombre")
    @NotNull(message = "nombre cant be null")
    private String nombre;

    @Column(name = "dies_anticipacion_reservas")
    private int dies_anticipacion_reservas;

    @Column(name = "telefono_restaurante")
    private long telefono_restaurante;

    @Column(name = "validated")
    @NotNull(message = "validated cant be null")
    private boolean validated;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_localidad")
    @NotNull(message = "id_localidad cant be null")
    private Localidad localidad;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_membresia")
    @NotNull(message = "id_membresia cant be null")
    private Membresia membresia;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_user")
    @NotNull(message = "id_user cant be null")
    private Useracount useracount;

    @Column(name = "visible")
    @NotNull(message = "visible cant be null")
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
