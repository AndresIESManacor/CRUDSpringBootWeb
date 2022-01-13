package com.example.crudspringbootweb.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @Column(name = "num_factura")
    private String num_factura;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "importe")
    private float importe;

    public Factura(String num_factura, String direccion, float importe) {
        this.num_factura = num_factura;
        this.direccion = direccion;
        this.importe = importe;
    }

    public Factura() {

    }
}