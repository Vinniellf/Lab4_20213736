package com.example.tareagtics.Models.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "flores")
public class Flores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idflores", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "imagen", nullable = false , length = 200)
    private String imagen;

    @Column(name = "precio", nullable = false , length = 25)
    private Double email;

    @Column(name = "descripcion", nullable = false , length = 500)
    private String descripcion;


    // Cambiar el departamento a una relación
    @ManyToOne
    @JoinColumn(name = "color")
    private Color department;  // Relación con Department

    @ManyToOne
    @JoinColumn(name = "tipo")
    private Tipo job;

    @ManyToOne
    @JoinColumn(name = "Ocasion")
    private Ocasion ocasion;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getEmail() {
        return email;
    }

    public void setEmail(Double email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Color getDepartment() {
        return department;
    }

    public void setDepartment(Color department) {
        this.department = department;
    }

    public Tipo getJob() {
        return job;
    }

    public void setJob(Tipo job) {
        this.job = job;
    }

    public Ocasion getOcasion() {
        return ocasion;
    }

    public void setOcasion(Ocasion ocasion) {
        this.ocasion = ocasion;
    }
}
