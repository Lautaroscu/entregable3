package tp3.entregable3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp3.entregable3.DTOs.alumno.InputAlumnoDTO;
import tp3.entregable3.DTOs.alumno.OutputAlumnoDTO;
import tp3.entregable3.exceptions.BadRequestException;
import tp3.entregable3.exceptions.NotFoundException;
import tp3.entregable3.services.AlumnoService;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<OutputAlumnoDTO>> getAlumnos() {
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.findAll());
    }

    @GetMapping("/{nroLibreta}")
    public ResponseEntity<?> getAlumno(@PathVariable int nroLibreta) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(alumnoService.findById(nroLibreta));
        } catch (NotFoundException e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<?> saveAlumno(@RequestBody InputAlumnoDTO alumnoDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.create(alumnoDTO));
        }catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("/{nroLibreta}")
    public ResponseEntity<?> updateAlumno(@PathVariable int nroLibreta, @RequestBody InputAlumnoDTO alumnoDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.update(nroLibreta, alumnoDTO));
        }catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/{nroLibreta}")
    public ResponseEntity<?> deleteAlumno(@PathVariable int nroLibreta) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
        }catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
