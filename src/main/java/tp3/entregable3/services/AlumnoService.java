package tp3.entregable3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp3.entregable3.DTOs.alumno.InputAlumnoDTO;
import tp3.entregable3.DTOs.alumno.OutputAlumnoDTO;
import tp3.entregable3.entities.Alumno;
import tp3.entregable3.exceptions.BadRequestException;
import tp3.entregable3.exceptions.NotFoundException;
import tp3.entregable3.repositories.AlumnoRepository;

import java.util.List;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;
    public List<OutputAlumnoDTO> findAll(){
        return alumnoRepository
                .findAll()
                .stream()
                .map(OutputAlumnoDTO::new)
                .toList();
    }
    public OutputAlumnoDTO findById(int id){
        Alumno alumno = alumnoRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        return new OutputAlumnoDTO(alumno);
    }
    public OutputAlumnoDTO create(InputAlumnoDTO alumnoDTO){
        if(isBadRequest(alumnoDTO)){
            throw new BadRequestException("Bad request , check the fields and try again");
        }
        Alumno alumno = new Alumno(alumnoDTO.getNombre() , alumnoDTO.getApellido() , alumnoDTO.getEdad() , alumnoDTO.getGenero() , alumnoDTO.getCiudad_residencia());
        alumnoRepository.save(alumno);
        return new OutputAlumnoDTO(alumno);
    }
    public OutputAlumnoDTO update(int id, InputAlumnoDTO alumnoDTO){
        Alumno alumnoToUpdate = alumnoRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        if(isBadRequest(alumnoDTO)){
            throw new BadRequestException("Bad request , check the fields and try again");
        }
        //aunque solo quieran editar un solo campo, deben pasar el objeto completo por body
        alumnoToUpdate.setNombre(alumnoDTO.getNombre());
        alumnoToUpdate.setApellido(alumnoDTO.getApellido());
        alumnoToUpdate.setEdad(alumnoDTO.getEdad());
        alumnoToUpdate.setGenero(alumnoDTO.getGenero());
        alumnoToUpdate.setCiudad_residencia(alumnoDTO.getCiudad_residencia());
        alumnoRepository.save(alumnoToUpdate);
        return new OutputAlumnoDTO(alumnoToUpdate);

    }
    public void delete(int id){
        if(!alumnoRepository.existsById(id)){
            throw new NotFoundException("User not found");
        }
        alumnoRepository.deleteById(id);
    }

    private boolean isBadRequest(InputAlumnoDTO alumno){
        return alumno.getNombre() == null || alumno.getNombre().isEmpty() || alumno.getApellido() == null || alumno.getApellido().isEmpty()
                || alumno.getEdad() <= 0 || alumno.getEdad() > 150
                || alumno.getGenero() == null || alumno.getGenero().isEmpty()
                || alumno.getCiudad_residencia() == null || alumno.getCiudad_residencia().isEmpty();
    }
}
