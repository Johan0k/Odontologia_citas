package ec.webmarket.restful.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique= true)
    private String cedula;

    @Column(updatable= false)
    private String nombre;

    @Column(updatable= false)
    private String apellido;
    
     @Column(updatable= false, unique= true)
    private String telefono;
     
     @Column(updatable= false, unique = true)
      private String email;


    @Column(updatable= false, unique= true)
    private String fechaNacimiento;

    @Column(updatable= false)
    private String direccion;



}