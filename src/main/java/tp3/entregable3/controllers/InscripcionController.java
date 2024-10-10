package tp3.entregable3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tp3.entregable3.DTOs.inscripcion.InputInscripcionDTO;
import tp3.entregable3.DTOs.inscripcion.OutputInscripcionDTO;
import tp3.entregable3.exceptions.NotFoundException;
import tp3.entregable3.repositories.AlumnoRepository;
import tp3.entregable3.repositories.CarreraRepository;
import tp3.entregable3.repositories.InscripcionRepository;
import tp3.entregable3.services.InscripcionService;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")

public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping
    public ResponseEntity<?> altaAlumnoCarrera(InputInscripcionDTO dto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(inscripcionService.altaAlumnoCarrera(dto));
        }catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



}
