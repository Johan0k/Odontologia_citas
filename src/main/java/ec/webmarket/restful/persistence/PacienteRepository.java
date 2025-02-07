package ec.webmarket.restful.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.webmarket.restful.domain.Paciente;

public interface PacienteRepository  extends JpaRepository<Paciente, Long>{

}
