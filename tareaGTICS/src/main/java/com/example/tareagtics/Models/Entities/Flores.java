package com.example.tareagtics.Models.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "flores")
public class Flores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idflores", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false , length = 100)
    private String nombre;

    @Column(name = "imagen", nullable = false , length = 500)
    private String imagen;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "descripcion", nullable = false , length = 200)
    private String descripcion;



    @ManyToOne
    @JoinColumn(name = "color_idcolor")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "tipo_idtipo")
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name = "ocasion_idocasion")
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Ocasion getOcasion() {
        return ocasion;
    }

    public void setOcasion(Ocasion ocasion) {
        this.ocasion = ocasion;
    }
}
