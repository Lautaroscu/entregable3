package tp3.entregable3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp3.entregable3.DTOs.inscripcion.InputInscripcionDTO;
import tp3.entregable3.DTOs.inscripcion.OutputInscripcionDTO;
import tp3.entregable3.exceptions.BadRequestException;
import tp3.entregable3.exceptions.NotFoundException;

import tp3.entregable3.services.InscripcionService;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")

public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping
    public ResponseEntity<List<OutputInscripcionDTO>> listarInscripciones() {
        return ResponseEntity.status(HttpStatus.OK).body(inscripcionService.obtenerInscripciones());
    }

    @GetMapping("/{nroLibreta}/{idCarrera}")
    public ResponseEntity<?> findInscripcion(@PathVariable int nroLibreta, @PathVariable int idCarrera) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(inscripcionService.findInscripcion(idCarrera, nroLibreta));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> altaAlumnoCarrera(@RequestBody InputInscripcionDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(inscripcionService.altaAlumnoCarrera(dto));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{idCarrera}/{nroLibreta}")
    public ResponseEntity<?> updateInscripcion(@PathVariable int idCarrera, @PathVariable int nroLibreta, @RequestBody InputInscripcionDTO dto) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(inscripcionService.updateInscripcion(idCarrera, nroLibreta, dto));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{nroLibreta}/{idCarrera}")
    public ResponseEntity<?> delete(@PathVariable int nroLibreta, @PathVariable int idCarrera) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(inscripcionService.delete(nroLibreta, idCarrera));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
