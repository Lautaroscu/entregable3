package tp3.entregable3.DTOs.carrera;


import tp3.entregable3.entities.Carrera;


public class OutputCarreraDTO {
    private int id;
    private String nombre;

    public OutputCarreraDTO(Carrera c) {
        this.id = c.getId_carrera();
        this.nombre = c.getNombre();
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
