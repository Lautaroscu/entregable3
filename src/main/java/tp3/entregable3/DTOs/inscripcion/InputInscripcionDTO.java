package tp3.entregable3.DTOs.inscripcion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tp3.entregable3.entities.Inscripcion;

import java.time.LocalDate;


public class InputInscripcionDTO {
    private int idCarrera;
    private int nroLibreta;
    private boolean seGraduo;
    private LocalDate fechaInscripcion;

    public InputInscripcionDTO(Inscripcion inscripcion) {
        this.idCarrera = inscripcion.getIdCarrera();
        this.nroLibreta = inscripcion.getNroLibreta();
        this.seGraduo = inscripcion.isSeGraduo();
        this.fechaInscripcion = inscripcion.getFechaInscripcion();
    }
    public InputInscripcionDTO(int idCarrera, int nroLibreta) {
        this.idCarrera = idCarrera;
        this.nroLibreta = nroLibreta;
    }
    public int getIdCarrera() {
        return idCarrera;
    }
    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }
    public int getNroLibreta() {
        return nroLibreta;
    }
    public void setNroLibreta(int nroLibreta) {
        this.nroLibreta = nroLibreta;
    }
    public boolean isSeGraduo() {
        return seGraduo;
    }
    public void setSeGraduo(boolean seGraduo) {
        this.seGraduo = seGraduo;
    }
    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }
    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
