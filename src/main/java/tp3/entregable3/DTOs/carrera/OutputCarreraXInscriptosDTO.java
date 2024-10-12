package tp3.entregable3.DTOs.carrera;

import lombok.Getter;
import lombok.Setter;
import tp3.entregable3.entities.Carrera;

@Getter
@Setter

public class OutputCarreraXInscriptosDTO extends OutputCarreraDTO {
    private Long cantInscriptos;

    public OutputCarreraXInscriptosDTO(Carrera c, Long cantInscriptos) {
        super(c);
        this.cantInscriptos = cantInscriptos;
    }
}
