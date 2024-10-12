package tp3.entregable3.DTOs.inscripcion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tp3.entregable3.entities.Alumno;
import tp3.entregable3.entities.Carrera;
import tp3.entregable3.entities.Inscripcion;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class OutputInscripcionDTO {
    private Carrera carrera;
    private Alumno alumno;
    private boolean seGraduo;
    private LocalDate fechaInscripcion;

    public OutputInscripcionDTO(Inscripcion inscripcion) {
        this.carrera = inscripcion.getCarrera();
        this.alumno = inscripcion.getAlumno();
        this.seGraduo = inscripcion.isSeGraduo();
        this.fechaInscripcion = inscripcion.getFechaInscripcion();
    }
}
