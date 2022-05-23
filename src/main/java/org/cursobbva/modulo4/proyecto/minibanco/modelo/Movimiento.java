package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Entity
public abstract class Movimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "{movimiento.fechaHora}")
	@PastOrPresent(message = "{movimiento.fechaHora.pasado}")
	@Column(updatable=false)
	private LocalDateTime fechayHoraDeRealizacion;
	@Positive(message="{movimiento.monto}")
	@Column(updatable=false)
	private float monto;
	@NotEmpty(message = "{movimiento.descripcion}")
	@Column(updatable=false)
	private String descripcion;
	@ManyToOne
	@JoinColumn(name="Cuenta_Id")
//	@NotNull(message = "{movimiento.cuenta}")
	private Cuenta cuenta;
	

	//CONSTRUCTORES
	public Movimiento(LocalDateTime fechayHoraDeRealizacion, float monto, String descripcion) {
		super();
		this.fechayHoraDeRealizacion = fechayHoraDeRealizacion;
		this.monto = monto;
		this.descripcion = descripcion;
	}
	public Movimiento() {}
	
	
	//GETTERS Y SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getFechayHoraDeRealizacion() {
		return fechayHoraDeRealizacion;
	}
	public void setFechayHoraDeRealizacion(LocalDateTime fechayHoraDeRealizacion) {
		this.fechayHoraDeRealizacion = fechayHoraDeRealizacion;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	
}
