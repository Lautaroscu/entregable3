package tp3.entregable3.entities;

import jakarta.persistence.*;

@Entity

@Table(name = "carrera")

public class Carrera {

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public int getId_carrera() {
        return id_carrera;
    }
}