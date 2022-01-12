package com.example.crudspringbootweb.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Factura")
public class Factura {
    @Id
    @Column(name = "numFactura")
    private String numFactura;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "importe")
    private float importe;

    public Factura(String numFactura, String direccion, float importe) {
        this.numFactura = numFactura;
        this.direccion = direccion;
        this.importe = importe;
    }

    public Factura() {

    }
}