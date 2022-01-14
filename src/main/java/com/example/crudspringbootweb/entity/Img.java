package com.example.crudspringbootweb.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "img")
public class Img {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_img")
    @Min(0)
    BigInteger id_img;

    @Column(name="url")
    @NotNull(message = "url cant be null")
    @Pattern(regexp = "[png|jpg|gif]$",message = "Cant use specials characters")
    String url;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_restaurante")
    @NotNull(message = "id_restaurante cant be null")
    private Restaurant restaurant;

    public Img(BigInteger id_img, String url, Restaurant restaurant) {
        this.id_img = id_img;
        this.url = url;
        this.restaurant = restaurant;
    }

    public Img(String url, Restaurant restaurant) {
        this.url = url;
        this.restaurant = restaurant;
    }

    public Img() {}
}
