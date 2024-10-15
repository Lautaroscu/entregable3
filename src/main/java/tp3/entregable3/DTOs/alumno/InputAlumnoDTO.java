package tp3.entregable3.DTOs.alumno;



import java.io.Serializable;


public class InputAlumnoDTO implements Serializable {
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String ciudad_residencia;
    public InputAlumnoDTO() {

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

}
