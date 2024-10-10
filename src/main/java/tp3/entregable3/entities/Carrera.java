package tp3.entregable3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@Table(name = "carrera")

public class Carrera {
    public final static String CARRERASSORTCANTINSC = "Carrera.CarrerasSortCantInsc";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_carrera;

    @Column
    private String nombre;

    public Carrera() {
    }

    public Carrera(String nombre) {
        this.nombre = nombre;
    }
}