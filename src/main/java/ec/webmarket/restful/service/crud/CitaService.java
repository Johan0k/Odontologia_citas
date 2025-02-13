package ec.webmarket.restful.service.crud;

import ec.webmarket.restful.domain.Cita;
import ec.webmarket.restful.persistence.CitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public Cita crearCita(Cita cita) {
        
        if (cita.getHorario().isDisponibilidad()) {
            
            cita.getHorario().setDisponibilidad(false);
            return citaRepository.save(cita);
        }
        throw new RuntimeException("El horario no está disponible");
    }

    public Cita actualizarCita(Long id, Cita cita) {
        Optional<Cita> citaExistente = citaRepository.findById(id);
        if (citaExistente.isPresent()) {
            Cita c = citaExistente.get();
            c.setPaciente(cita.getPaciente());
            c.setOdontologo(cita.getOdontologo());
            c.setHorario(cita.getHorario());
            c.setFechaHora(cita.getFechaHora());
            c.setEstado(cita.getEstado());
            c.setMotivo(cita.getMotivo());
            return citaRepository.save(c);
        }
        throw new RuntimeException("Cita no encontrada");
    }

    public String cancelarCita(Long id) {
        Optional<Cita> cita = citaRepository.findById(id);
        if (cita.isPresent()) {
            Cita c = cita.get();
            c.setEstado("cancelada");
            citaRepository.save(c);
            return "Cita cancelada correctamente";
        }
        throw new RuntimeException("Cita no encontrada");
    }

    public List<Cita> obtenerHistorialPorPaciente(String pacienteCedula) {
        return citaRepository.findByPacienteCedula(pacienteCedula);
    }

    public List<Cita> obtenerHistorialPorOdontologo(String odontologoCedula) {
        return citaRepository.findByOdontologoCedula(odontologoCedula);
    }

    public List<Cita> obtenerTodasLasCitas() {
        return citaRepository.findAll();
    }
}