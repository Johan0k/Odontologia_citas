package ec.webmarket.restful.service.crud;

import ec.webmarket.restful.domain.Horario;
import ec.webmarket.restful.persistence.HorarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public Horario crearHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    public Horario actualizarHorario(Long id, Horario horario) {
        Optional<Horario> horarioExistente = horarioRepository.findById(id);
        if (horarioExistente.isPresent()) {
            Horario h = horarioExistente.get();
            h.setFecha(horario.getFecha());
            h.setHoraInicio(horario.getHoraInicio());
            h.setHoraFin(horario.getHoraFin());
            h.setDisponibilidad(horario.isDisponibilidad());
            h.setOdontologo(horario.getOdontologo());
            return horarioRepository.save(h);
        }
        throw new RuntimeException("Horario no encontrado");
    }

    public String bloquearHorario(Long id) {
        Optional<Horario> horario = horarioRepository.findById(id);
        if (horario.isPresent()) {
            Horario h = horario.get();
            h.setDisponibilidad(false);
            horarioRepository.save(h);
            return "Horario bloqueado correctamente";
        } else {
            throw new RuntimeException("Horario no encontrado");
        }
    }


    public List<Horario> obtenerHorariosDisponibles() {
        return horarioRepository.findByDisponibilidad(true);
    }

    public List<Horario> obtenerHorariosPorOdontologo(String odontologoId) {
        return horarioRepository.findByOdontologoCedula(odontologoId);
    }

    public List<Horario> obtenerHorariosPorFecha(LocalDate fecha) {
        return horarioRepository.findByFecha(fecha);
    }
    public List<Horario> obtenerTodosLosHorarios() {
        return horarioRepository.findAll();
    }
}