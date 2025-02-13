package ec.webmarket.restful.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Horario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDate fecha;
	
	@Column(nullable = false)
	private LocalTime horaInicio;
	
	@Column(nullable = false)
	private LocalTime horaFin;
	
	@Column(nullable = false)
	private boolean disponibilidad;
	
	@ManyToOne
	@JoinColumn(name = "odontologo_id")
	private Odontologo odontologo;

}