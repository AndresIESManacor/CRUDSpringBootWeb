package com.example.crudspringbootweb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_acount")
public class Useracount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id_user;

    @Column(name = "nombre_usuario")
    private String nombre_usuario;

    @Column(name = "contraseña")
    private String password;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private long telefono;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido1")
    private String apellido1;

    @Column(name = "apellido2")
    private String apellido2;

    @Column(name = "dni")
    private String dni;

    @Column(name = "admin")
    private boolean admin;

    public Useracount(String nombre_usuario, String password, String correo, long telefono, String nombre, String apellido1, String apellido2, String dni, boolean admin) {
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.correo = correo;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.admin = admin;
    }

    public Useracount(int id_user, String nombre_usuario, String password, String correo, long telefono, String nombre, String apellido1, String apellido2, String dni, boolean admin) {
        this.id_user = id_user;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.correo = correo;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.admin = admin;
    }

    public Useracount() {

    }
}