package model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "equipos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_equipo", nullable = false)
    private String nombreEquipo;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @ManyToOne
    @JoinColumn(name = "id_liga", nullable = false)
    private Liga liga;

    @OneToOne(mappedBy = "equipo")
    private Entrenador entrenador; // Relación con Entrenador

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private List<Jugador> jugadores;


    public Equipo(String nombreEquipo, String ciudad, Liga liga) {
        this.nombreEquipo = nombreEquipo;
        this.ciudad = ciudad;
        this.liga = liga;
    }
}
