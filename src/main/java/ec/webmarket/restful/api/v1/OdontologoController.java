package ec.webmarket.restful.api.v1;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.webmarket.restful.domain.Cita;
import ec.webmarket.restful.dto.v1.OdontologoDTO;

import ec.webmarket.restful.security.ApiResponseDTO;
import ec.webmarket.restful.service.crud.OdontologoService;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/v1/odontologo")
public class OdontologoController {
	

		@Autowired
		private OdontologoService entitysService;

		
		@GetMapping("/listar")
		public ResponseEntity<?> getAll() {
			return new ResponseEntity<>(new ApiResponseDTO<>(true, entitysService.findAll(new OdontologoDTO())), HttpStatus.OK);
		}

		
		@PostMapping
		public ResponseEntity<?> create(@RequestBody OdontologoDTO dto) {
			return new ResponseEntity<>(new ApiResponseDTO<>(true, entitysService.create(dto)), HttpStatus.CREATED);
		}
		

		@PutMapping
		public ResponseEntity<?> update(@RequestBody OdontologoDTO dto) {
			return new ResponseEntity<>(new ApiResponseDTO<>(true, entitysService.update(dto)), HttpStatus.OK);
		}
		

		@GetMapping("/{id}")
		public ResponseEntity<?> getById(@Valid @PathVariable Long id) {
			OdontologoDTO dto = new OdontologoDTO();
			dto.setId(id);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, entitysService.find(dto)), HttpStatus.OK);
		}
		
		

		@DeleteMapping("/{id}")
		public ResponseEntity<?> deleteById(@PathVariable Long id) {
		    OdontologoDTO dto = new OdontologoDTO();
		    dto.setId(id);
		    entitysService.delete(dto);
		    return new ResponseEntity<>(new ApiResponseDTO<>(true, "Odontólogo eliminado"), HttpStatus.OK);
		}
		
		@GetMapping("/citas/{cedula}")
		public ResponseEntity<List<Cita>> obtenerCitasAsignadas(@PathVariable String cedula) {
		    return ResponseEntity.ok(entitysService.obtenerCitasAsignadas(cedula));
		}
		

		
		}
		


