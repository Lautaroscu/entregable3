package tp3.entregable3.DTOs.alumno;


import lombok.ToString;


@ToString
public class AlumnoFiltersDTO {
    private String genero, ciudadRecidencia, carrera;

    public AlumnoFiltersDTO(String genero, String ciudadRecidencia, String carrera) {
        this.genero = genero;
        this.ciudadRecidencia = ciudadRecidencia;
        this.carrera = carrera;
    }

    public String getGenero() {
        return genero;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getCiudadRecidencia() {
        return ciudadRecidencia;
    }
}
