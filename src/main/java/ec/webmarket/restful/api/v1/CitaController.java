package ec.webmarket.restful.api.v1;

import ec.webmarket.restful.domain.Cita;
import ec.webmarket.restful.service.crud.CitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @PostMapping("/crear")
    public ResponseEntity<Cita> crearCita(@RequestBody Cita cita) {
        return ResponseEntity.ok(citaService.crearCita(cita));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Cita> actualizarCita(@PathVariable Long id, @RequestBody Cita cita) {
        return ResponseEntity.ok(citaService.actualizarCita(id, cita));
    }

    @PutMapping("/cancelar/{id}")
    public ResponseEntity<String> cancelarCita(@PathVariable Long id) {
        String mensaje = citaService.cancelarCita(id);
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/historial/paciente/{cedula}")
    public ResponseEntity<List<Cita>> obtenerHistorialPorPaciente(@PathVariable String cedula) {
        return ResponseEntity.ok(citaService.obtenerHistorialPorPaciente(cedula));
    }

    @GetMapping("/historial/odontologo/{cedula}")
    public ResponseEntity<List<Cita>> obtenerHistorialPorOdontologo(@PathVariable String cedula) {
        return ResponseEntity.ok(citaService.obtenerHistorialPorOdontologo(cedula));
    }

    @GetMapping("/todas")
    public ResponseEntity<List<Cita>> obtenerTodasLasCitas() {
        return ResponseEntity.ok(citaService.obtenerTodasLasCitas());
    }
}