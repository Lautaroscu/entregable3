package tp3.entregable3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tp3.entregable3.services.CarreraService;

@RestController
@RequestMapping("/api/carreras")
public class CarreraController {
    @Autowired
    private CarreraService carreraService;

    @GetMapping
    public ResponseEntity<?> getAllCarreras(
            //posible caso de activacion --> /api/carreras?sortByInscriptos=true
            //defualt : false = allCarreras
            @RequestParam(value = "sortByInscriptos", required = false) boolean sortByInscriptos) {

        if (sortByInscriptos) {
            // Si hay un campo de orden, devolver ordenado por el campo especificado
            return ResponseEntity.status(HttpStatus.OK).body(carreraService.getCarreraXInscriptos());
        }
        return ResponseEntity.status(HttpStatus.OK).body(carreraService.findAll());
    }
}
