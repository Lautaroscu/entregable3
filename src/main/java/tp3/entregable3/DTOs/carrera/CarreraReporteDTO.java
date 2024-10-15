package tp3.entregable3.DTOs.carrera;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class CarreraReporteDTO {
    private String nombreCarrera;
    private int anio;
    private long cantidadInscriptos;
    private long cantidadEgresados;

    public CarreraReporteDTO(String nombreCarrera, int anio, long cantidadInscriptos, long cantidadEgresados) {
        this.nombreCarrera = nombreCarrera;
        this.anio = anio;
        this.cantidadInscriptos = cantidadInscriptos;
        this.cantidadEgresados = cantidadEgresados;
    }

    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public long getCantidadInscriptos() {
        return cantidadInscriptos;
    }
    public void setCantidadInscriptos(long cantidadInscriptos) {
        this.cantidadInscriptos = cantidadInscriptos;
    }
    public long getCantidadEgresados() {
        return cantidadEgresados;
    }
    public void setCantidadEgresados(long cantidadEgresados) {
        this.cantidadEgresados = cantidadEgresados;
    }
    public String getNombreCarrera() {
        return nombreCarrera;
    }
    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

}