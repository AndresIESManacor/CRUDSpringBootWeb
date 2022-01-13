package com.example.crudspringbootweb.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "img")
public class Img {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_img")
    int id_img;

    @Column(name="url")
    String url;

    @OneToOne(optional = false)
    @JoinColumn(name = "id_restaurante")
    private Restaurant restaurant;

    public Img(int id_img, String url, Restaurant restaurant) {
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
