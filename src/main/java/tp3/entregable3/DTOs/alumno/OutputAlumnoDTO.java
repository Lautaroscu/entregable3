package tp3.entregable3.DTOs.alumno;

import tp3.entregable3.entities.Alumno;

import java.io.Serializable;


public class OutputAlumnoDTO implements Serializable {
    private int nro_libreta;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String ciudad_residencia;

    public OutputAlumnoDTO(Alumno a) {
        this.nombre = a.getNombre();
        this.apellido = a.getApellido();
        this.edad = a.getEdad();
        this.genero = a.getGenero();
        this.ciudad_residencia = a.getCiudad_residencia();
        this.nro_libreta = a.getNro_libreta();

    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getCiudad_residencia() {
        return ciudad_residencia;
    }
    public void setCiudad_residencia(String ciudad_residencia) {
        this.ciudad_residencia = ciudad_residencia;
    }
    public int getNro_libreta() {
        return nro_libreta;
    }
    public void setNro_libreta(int nro_libreta) {
        this.nro_libreta = nro_libreta;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

}
