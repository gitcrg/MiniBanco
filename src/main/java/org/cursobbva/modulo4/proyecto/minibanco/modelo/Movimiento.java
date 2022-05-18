package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private LocalDateTime fechayHoraDeRealizacion;
	private float monto;
	private String descripci�n;
	@ManyToOne
	private Cuenta cuenta;
	
	public Movimiento(LocalDateTime fechayHoraDeRealizacion, float monto, String descripci�n) {
		super();
		this.fechayHoraDeRealizacion = fechayHoraDeRealizacion;
		this.monto = monto;
		this.descripci�n = descripci�n;
	}
	public Movimiento() {}

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

	public String getDescripci�n() {
		return descripci�n;
	}

	public void setDescripci�n(String descripci�n) {
		this.descripci�n = descripci�n;
	}
	
	
	
}
