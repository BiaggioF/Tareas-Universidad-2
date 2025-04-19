package com.example.almacenAPI.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@IdClass(ProduccionId.class)
@Table(name = "produccion")
public class Produccion implements Serializable {

    @Id
    @Column(name = "trabajador_id")
    private Integer trabajadorId;

    @Id
    @Column(name = "almacen_id")
    private Integer almacenId;

    @Id
    private LocalDate fecha;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "trabajador_id", insertable = false, updatable = false)
    private Trabajador trabajador;

    @ManyToOne
    @JoinColumn(name = "almacen_id", insertable = false, updatable = false)
    private Almacen almacen;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    public Produccion() { }

    public Produccion(Integer trabajadorId, Integer almacenId, LocalDate fecha,
                      BigDecimal valor, Producto producto) {
        this.trabajadorId = trabajadorId;
        this.almacenId   = almacenId;
        this.fecha       = fecha;
        this.valor       = valor;
        this.producto    = producto;
    }

    // Getters y setters

    public Integer getTrabajadorId() {
        return trabajadorId;
    }
    public Integer getAlmacenId() {
        return almacenId;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public Trabajador getTrabajador() {
        return trabajador;
    }
    public Almacen getAlmacen() {
        return almacen;
    }
    public Producto getProducto() {
        return producto;
    }

    public void setTrabajadorId(Integer trabajadorId) {
        this.trabajadorId = trabajadorId;
    }
    public void setAlmacenId(Integer almacenId) {
        this.almacenId = almacenId;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
