package com.example.crudspringbootweb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "UserAcount")
public class Useracount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private int idUser;

    @Column(name = "nombreUsuario")
    private String nombreUsuario;

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

    @Column(name = "isAdmin")
    private boolean isAdmin;

    public Useracount(String nombreUsuario, String password, String correo, long telefono, String nombre, String apellido1, String apellido2, String dni, boolean isAdmin) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.correo = correo;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.isAdmin = isAdmin;
    }

    public Useracount(int idUser, String nombreUsuario, String password, String correo, long telefono, String nombre, String apellido1, String apellido2, String dni, boolean isAdmin) {
        this.idUser = idUser;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.correo = correo;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.isAdmin = isAdmin;
    }

    public Useracount() {

    }
}