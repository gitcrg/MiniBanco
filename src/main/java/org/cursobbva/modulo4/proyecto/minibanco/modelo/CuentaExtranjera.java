package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Entity
public class CuentaExtranjera extends Cuenta{

	@Enumerated(EnumType.STRING)
	private TipoMoneda moneda;

	//CONSTRUCTORES
	public CuentaExtranjera(LocalDate fechaDeCreacion, float saldoInicial, float saldoActual, float descubiertoAcordado,
			LocalDate fechaDeCierre, Cliente titular, TipoMoneda moneda) {
		super(fechaDeCreacion, saldoInicial, saldoActual, descubiertoAcordado, fechaDeCierre, titular);
		this.moneda = moneda;
	}
	public CuentaExtranjera() {}
	
	//GETTERS Y SETTERS
	public TipoMoneda getMoneda() {
		return moneda;
	}
	public void setMoneda(TipoMoneda moneda) {
		this.moneda = moneda;
	}

	
	
}
