package tp3.entregable3.repositories;

import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import tp3.entregable3.entities.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
//    @NamedQuery(name = Alumno.ALUMNOSSORTNROLIB, query = "SELECT a FROM Alumno a ORDER BY a.nro_libreta")
//
//    @NamedQuery(name = Alumno.ALUMNOSPORGENERO, query = "SELECT a FROM Alumno a WHERE a.genero = :genero")
//
//    @NamedQuery(name = Alumno.ALUMNOCARRERAYCIUDAD, query = "SELECT a FROM Alumno a WHERE a.ciudad_residencia = :ciudad AND a IN (SELECT i.alumno FROM Inscripcion i WHERE i.carrera.nombre = :carrera)")
//
//    @NamedQuery(name = Alumno.LISTARALUMNOSSORTAPELLIDO, query = "SELECT a FROM Alumno a ORDER BY a.apellido")
//
//    @NamedQuery(name = Alumno.LISTARALUMNOS, query = "SELECT a FROM Alumno a ORDER BY a.apellido")
}
