package com.example.tareagtics.Models.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ocasion")
public class Ocasion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idocasion", nullable = false)
    private Integer id;

    @Column(name = "nameocasion", nullable = false, length = 45)
    private String name;

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
}
