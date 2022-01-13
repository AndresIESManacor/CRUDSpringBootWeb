package com.example.crudspringbootweb.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "IMG")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idImg")
    int idImg;

    @Column(name="url")
    String url;

    @OneToOne(optional = false)
    @JoinColumn(name = "idRestaurante")
    private Restaurant restaurant;

    public Image(int idImg, String url, Restaurant restaurant) {
        this.idImg = idImg;
        this.url = url;
        this.restaurant = restaurant;
    }

    public Image(String url, Restaurant restaurant) {
        this.url = url;
        this.restaurant = restaurant;
    }

    public Image() {}
}
