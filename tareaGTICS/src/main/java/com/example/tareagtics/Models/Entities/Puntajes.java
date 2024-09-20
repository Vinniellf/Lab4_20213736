package com.example.tareagtics.Models.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "puntajes")
public class Puntajes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpuntajes", nullable = false)
    private Integer id;

    @Column(name = "nickname",nullable = false, length = 45)
    private String name;

    @Column(name = "puntajescol", nullable = false)
    private Integer puntos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
}
