// Almacen.java
package com.example.almacenAPI.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "almacenes")
public class Almacen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_almacen")
    private String nombreAlmacen;

    public Almacen() { }

    public Almacen(Integer id, String nombreAlmacen) {
        this.id = id;
        this.nombreAlmacen = nombreAlmacen;
    }

    public Almacen(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
    }

    public Integer getId() {
        return id;
    }

    public String getNombreAlmacen() {
        return nombreAlmacen;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombreAlmacen(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
    }
}
