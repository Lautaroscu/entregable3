package tp3.entregable3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tp3.entregable3.exceptions.BadRequestException;
import tp3.entregable3.exceptions.NotFoundException;
import tp3.entregable3.services.CarreraService;

@RestController
@RequestMapping("/api/carreras")
public class CarreraController {
    @Autowired
    private CarreraService carreraService;

    @GetMapping
    public ResponseEntity<?> getAllCarreras(
            @RequestParam(value = "sortByInscriptos", required = false) boolean sortByInscriptos,
            @RequestParam(value = "generarReporte", required = false) boolean generarReporte
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(carreraService.findAll(sortByInscriptos, generarReporte));
    }

    @GetMapping("/{idCarrera}")
    public ResponseEntity<?> getCarrera(@PathVariable int idCarrera) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(carreraService.findCarrera(idCarrera));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addCarrera(@RequestBody String nombre) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(carreraService.saveCarrera(nombre));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{idCarrera}")
    public ResponseEntity<?> deleteCarrera(@PathVariable int idCarrera) {
        try {
            return ResponseEntity.ok(carreraService.deleteCarrera(idCarrera));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{idCarrera}")
    public ResponseEntity<?> updateCarrera(@RequestBody String nombre, @PathVariable int idCarrera) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(carreraService.updateCarrera(idCarrera, nombre));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        }

    }
}
