package com.example.almacenAPI.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ProduccionId implements Serializable {
    private Integer trabajadorId;
    private Integer almacenId;
    private LocalDate fecha;

    public ProduccionId() { }

    public ProduccionId(Integer trabajadorId, Integer almacenId, LocalDate fecha) {
        this.trabajadorId = trabajadorId;
        this.almacenId = almacenId;
        this.fecha = fecha;
    }

    // equals() y hashCode() basados en los tres campos

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProduccionId)) return false;
        ProduccionId that = (ProduccionId) o;
        return Objects.equals(trabajadorId, that.trabajadorId) &&
                Objects.equals(almacenId,   that.almacenId)   &&
                Objects.equals(fecha,       that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trabajadorId, almacenId, fecha);
    }
}
