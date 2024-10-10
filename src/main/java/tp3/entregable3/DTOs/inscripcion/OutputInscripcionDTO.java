package tp3.entregable3.DTOs.inscripcion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tp3.entregable3.entities.Alumno;
import tp3.entregable3.entities.Carrera;

@Getter
@Setter
@AllArgsConstructor
public class OutputInscripcionDTO {
    private Carrera carrera;
    private Alumno alumno;
}
