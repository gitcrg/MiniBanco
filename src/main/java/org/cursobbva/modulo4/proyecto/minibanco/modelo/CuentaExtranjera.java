package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Entity(name = "CUENTAS_EXTRANJERAS")
@NamedQueries({
@NamedQuery(name="Cuenta.cuentaByMoneda", query="select cta from CUENTAS_EXTRANJERAS cta where cta.moneda=:moneda")})
@Data
@NoArgsConstructor
public class CuentaExtranjera extends Cuenta{

	@Enumerated(EnumType.STRING)
	private TipoMoneda moneda;

	public CuentaExtranjera(LocalDate fechaDeCreacion, Double saldoInicial, Double saldoActual, Double descubiertoAcordado, LocalDate fechaDeCierre, Cliente titular, TipoMoneda moneda) {
		super(fechaDeCreacion, saldoInicial, saldoActual, descubiertoAcordado, fechaDeCierre, titular);
		this.moneda = moneda;
	}
	
	public void agregarMovimiento(Venta vta) {
		setSaldoActual(getSaldoActual() - vta.getMonto());
		this.getMovimientos().add(vta);
		vta.setCuenta(this);
	}
	
	
}
