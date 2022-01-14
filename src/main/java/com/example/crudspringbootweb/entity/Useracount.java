package com.example.crudspringbootweb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_acount")
public class Useracount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    @NotNull(message = "id_user cant be null")
    @Min(0)
    private int id_user;

    @Column(name = "nombre_usuario")
    @NotNull(message = "nombre_usuario cant be null")
    @Pattern(regexp = "^[^ª!\"·$%&/()=?¿\\\\|@#~½¬{\\[\\]}Ç*+\\-`'¡º<>;,:._]*$",message = "Cant use specials characters")
    private String nombre_usuario;

    @Column(name = "contraseña")
    @NotNull(message = "contraseña cant be null")
    @Pattern(regexp = "^[^ª!\"·$%&/()=?¿\\\\|@#~½¬{\\[\\]}Ç*+\\-`'¡º<>;,:._]*$",message = "Cant use specials characters")
    private String password;

    @Column(name = "correo")
    @NotNull(message = "correo cant be null")
    @Email
    private String correo;

    @Column(name = "telefono")
    private long telefono;

    @Column(name = "nombre")
    @NotNull(message = "nombre cant be null")
    private String nombre;

    @Column(name = "apellido1")
    private String apellido1;

    @Column(name = "apellido2")
    private String apellido2;

    @Column(name = "dni")
    @NotNull(message = "dni cant be null")
    @Pattern(regexp = "^[0-9]{8}[A-Za-z]$",message = "Cant use specials characters")
    private String dni;

    @Column(name = "admin")
    @NotNull(message = "admin cant be null")
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