package com.example.crudspringbootweb.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "id_membresia cant be null")
    @Min(0)
    private int id_membresia;

    @Column(name = "fecha_inicio")
    @NotNull(message = "fecha_inicio cant be null")
    private Timestamp fecha_inicio;

    @Column(name = "fecha_fin")
    private Timestamp fecha_fin;

    @ManyToOne(optional = false)
    @JoinColumn(name = "num_factura")
    @NotNull(message = "num_factura cant be null")
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