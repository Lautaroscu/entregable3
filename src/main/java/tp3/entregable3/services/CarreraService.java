package tp3.entregable3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp3.entregable3.DTOs.carrera.OutputCarreraDTO;
import tp3.entregable3.DTOs.carrera.OutputCarreraXInscriptosDTO;
import tp3.entregable3.repositories.CarreraRepository;

import java.util.List;

@Service
public class CarreraService {
    @Autowired
    private CarreraRepository carreraRepository;

    public List<OutputCarreraDTO> findAll(){
        return carreraRepository
                .findAll()
                .stream()
                .map(OutputCarreraDTO::new)
                .toList();
    }
    public List<OutputCarreraXInscriptosDTO> getCarreraXInscriptos(){
        return carreraRepository
                .findCarrerasOrderByCantInscriptos();
    }
}
