package ec.webmarket.restful.api.v1;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.webmarket.restful.domain.Horario;
import ec.webmarket.restful.service.crud.HorarioService;

@RestController
@RequestMapping("/api/v1/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @PostMapping("/crear")
    public ResponseEntity<Horario> crearHorario(@RequestBody Horario horario) {
        return ResponseEntity.ok(horarioService.crearHorario(horario));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Horario> actualizarHorario(@PathVariable Long id, @RequestBody Horario horario) {
        return ResponseEntity.ok(horarioService.actualizarHorario(id, horario));
    }

    @PutMapping("/bloquear/{id}")
    public ResponseEntity<String> bloquearHorario(@PathVariable Long id) {
        String mensaje = horarioService.bloquearHorario(id);
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<Horario>> obtenerHorariosDisponibles() {
        return ResponseEntity.ok(horarioService.obtenerHorariosDisponibles());
    }

    @GetMapping("/odontologo/{odontologoId}")
    public ResponseEntity<List<Horario>> obtenerHorariosPorOdontologo(@PathVariable String odontologoId) {
        return ResponseEntity.ok(horarioService.obtenerHorariosPorOdontologo(odontologoId));
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<Horario>> obtenerHorariosPorFecha(@PathVariable String fecha) {
        return ResponseEntity.ok(horarioService.obtenerHorariosPorFecha(LocalDate.parse(fecha)));
    }
    
    @GetMapping("/todos")
    public ResponseEntity<List<Horario>> obtenerTodosLosHorarios() {
        return ResponseEntity.ok(horarioService.obtenerTodosLosHorarios());
    }
}
