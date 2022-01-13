package com.example.crudspringbootweb.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Data
@Entity
@Table(name = "Membresia")
public class Membresia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMembresia")
    private int idMembresia;

    @Column(name = "fechaInicio")
    private Timestamp fechaInicio;

    @Column(name = "fechaFin")
    private Timestamp fechaFin;

    @ManyToOne(optional = false)
    @JoinColumn(name = "numFactura")
    private Factura factura;

    public Membresia(int idMembresia, Timestamp fechaInicio, Timestamp fechaFin, Factura factura) {
        this.idMembresia = idMembresia;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.factura = factura;
    }
    public Membresia(int idMembresia, String fechaInicio, String fechaFin, Factura factura) {
        this.idMembresia = idMembresia;
        this.fechaInicio = convertStringToTimestamp(fechaInicio);
        this.fechaFin = convertStringToTimestamp(fechaFin);
        this.factura = factura;
    }

    public Membresia() {

    }

    public Membresia(Timestamp fechaInicio, Timestamp fechaFin, Factura factura) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.factura = factura;
    }

    public Membresia(String fechaInicio, String fechaFin, Factura factura) {
        this.fechaInicio = convertStringToTimestamp(fechaInicio);
        this.fechaFin = convertStringToTimestamp(fechaFin);
        this.factura = factura;
    }

    public static Timestamp convertStringToTimestamp(String strDate) {
        strDate = strDate.replace("T"," ");
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return Optional.of(strDate) //
                .map(str -> LocalDateTime.parse(str, formatter))
                .map(Timestamp::valueOf) //
                .orElse(null);
    }
}