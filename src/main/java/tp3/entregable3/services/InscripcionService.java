package tp3.entregable3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp3.entregable3.DTOs.alumno.OutputAlumnoDTO;
import tp3.entregable3.DTOs.inscripcion.InputInscripcionDTO;
import tp3.entregable3.DTOs.inscripcion.OutputInscripcionDTO;
import tp3.entregable3.entities.Alumno;
import tp3.entregable3.entities.Carrera;
import tp3.entregable3.entities.Inscripcion;
import tp3.entregable3.exceptions.NotFoundException;
import tp3.entregable3.repositories.AlumnoRepository;
import tp3.entregable3.repositories.CarreraRepository;
import tp3.entregable3.repositories.InscripcionRepository;

import java.time.LocalDate;

@Service
public class InscripcionService {
    @Autowired
    private InscripcionRepository inscripcionRepository;
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private CarreraRepository carreraRepository;

    public OutputInscripcionDTO altaAlumnoCarrera(InputInscripcionDTO dto) {
        Alumno alumno = alumnoRepository.findById(dto.getNroLibreta()).orElseThrow(() -> new NotFoundException("Student not found"));
        Carrera carrera = carreraRepository.findById(dto.getIdCarrera()).orElseThrow(() -> new NotFoundException("Carrera not found"));
        Inscripcion inscripcion = new Inscripcion(alumno , carrera , LocalDate.now());
        inscripcionRepository.save(inscripcion);
        return new OutputInscripcionDTO(carrera , alumno);
    }
}
