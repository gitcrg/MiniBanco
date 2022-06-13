package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@EqualsAndHashCode(callSuper=false)
public class CuentaExtranjera extends Cuenta{

	@Enumerated(EnumType.STRING)
	private TipoMoneda moneda;

	public CuentaExtranjera(LocalDate fechaDeCreacion, Double saldoInicial, Double saldoActual, Double descubiertoAcordado, LocalDate fechaDeCierre, Cliente titular, TipoMoneda moneda) {
		super(fechaDeCreacion, saldoInicial, saldoActual, descubiertoAcordado, fechaDeCierre, titular);
		this.moneda = moneda;
	}
	
	public void agregarMovimiento(Venta vta) {
		setSaldoActual(getSaldoActual() - vta.getMonto() - vta.getComision());
		this.getMovimientos().add(vta);
		vta.setCuenta(this);
	}

	public void agregarMovimiento(Compra cmp) {
		setSaldoActual(getSaldoActual() + cmp.getMonto());
		this.getMovimientos().add(cmp);
		cmp.setCuenta(this);
	}
	
}
