package ec.webmarket.restful.persistence;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.webmarket.restful.domain.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
    List<Horario> findByDisponibilidad(boolean disponibilidad);
    List<Horario> findByOdontologoCedula(String odontologoCedula);
    List<Horario> findByFecha(LocalDate fecha);
}
