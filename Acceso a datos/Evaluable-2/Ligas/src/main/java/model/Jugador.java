package model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jugadores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String posición;

    @Column(name = "valor_mercado")
    private Double valorMercado;

    @Column(nullable = false)
    private Integer goles;

    @Column(nullable = false)
    private String nacionalidad;

    // Relación con Equipo (muchos a uno)
    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    public Jugador(String nombre, String posición, Integer valorMercado, Integer goles, String nacionalidad, Equipo equipo) {
        this.nombre = nombre;
        this.posición = posición;
        this.valorMercado = Double.valueOf(valorMercado);
        this.goles = goles;
        this.nacionalidad = nacionalidad;
        this.equipo = equipo;
    }
}
