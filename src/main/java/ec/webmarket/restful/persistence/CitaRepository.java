package ec.webmarket.restful.persistence;

import ec.webmarket.restful.domain.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByPacienteCedula(String pacienteCedula);
    List<Cita> findByOdontologoCedula(String odontologoCedula);
}
