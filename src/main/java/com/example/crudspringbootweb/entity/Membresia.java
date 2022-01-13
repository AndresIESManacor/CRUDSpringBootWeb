package com.example.crudspringbootweb.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Data
@Entity
@Table(name = "membresia")
public class Membresia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_membresia")
    private int id_membresia;

    @Column(name = "fecha_inicio")
    private Timestamp fecha_inicio;

    @Column(name = "fecha_fin")
    private Timestamp fecha_fin;

    @ManyToOne(optional = false)
    @JoinColumn(name = "numFactura")
    private Factura factura;

    public Membresia(int id_membresia, Timestamp fecha_inicio, Timestamp fecha_fin, Factura factura) {
        this.id_membresia = id_membresia;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.factura = factura;
    }
    public Membresia(int id_membresia, String fecha_inicio, String fecha_fin, Factura factura) {
        this.id_membresia = id_membresia;
        this.fecha_inicio = convertStringToTimestamp(fecha_inicio);
        this.fecha_fin = convertStringToTimestamp(fecha_fin);
        this.factura = factura;
    }

    public Membresia() {

    }

    public Membresia(Timestamp fecha_inicio, Timestamp fecha_fin, Factura factura) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.factura = factura;
    }

    public Membresia(String fecha_inicio, String fecha_fin, Factura factura) {
        this.fecha_inicio = convertStringToTimestamp(fecha_inicio);
        this.fecha_fin = convertStringToTimestamp(fecha_fin);
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