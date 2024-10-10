package tp3.entregable3.repositories;

import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tp3.entregable3.DTOs.carrera.OutputCarreraXInscriptosDTO;
import tp3.entregable3.entities.Carrera;
import java.util.List;

public interface CarreraRepository extends JpaRepository<Carrera, Integer> {
    @Query("SELECT new tp3.entregable3.DTOs.carrera.OutputCarreraXInscriptosDTO(i.carrera, COUNT(i)) " +
            "FROM Inscripcion i " +
            "GROUP BY i.carrera " +
            "ORDER BY COUNT(i)")
    List<OutputCarreraXInscriptosDTO> findCarrerasOrderByCantInscriptos();


//    @NamedQuery(
//            name = "Carrera.ReporteInscriptosEgresados",
//            query = "SELECT new DTOs.carrera.CarreraReporteDTO(c.nombre, YEAR(i.fechaInscripcion), " +
//                    "COUNT(i), " +
//                    "SUM(CASE WHEN i.seGraduo = TRUE THEN 1 ELSE 0 END)) " +
//                    "FROM Inscripcion i " +
//                    "JOIN i.carrera c " +
//                    "GROUP BY c.nombre, YEAR(i.fechaInscripcion) " +
//                    "ORDER BY c.nombre, YEAR(i.fechaInscripcion)"
//    )
}
