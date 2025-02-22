package model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "entrenadores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer calificación;

    @Column(nullable = false)
    private Integer títulos;

    @OneToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    public Entrenador(String nombre, Integer calificación, Integer títulos, Equipo equipo) {
        this.nombre = nombre;
        this.calificación = calificación;
        this.títulos = títulos;
        this.equipo = equipo;
    }
}
