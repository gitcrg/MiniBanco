package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Entity(name = "CUENTAS_LOCALES")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class CuentaLocal extends Cuenta{

	public CuentaLocal(LocalDate fechaDeCreacion, Double saldoInicial, Double saldoActual, Double descubiertoAcordado, LocalDate fechaDeCierre, Cliente titular) {
		super(fechaDeCreacion, saldoInicial, saldoActual, descubiertoAcordado, fechaDeCierre, titular);
	}

	public void agregarMovimiento(Venta vta) {
		setSaldoActual(getSaldoActual() + (vta.getMonto()*vta.getCotizacion()));
		this.getMovimientos().add(vta);
		vta.setCuenta(this);
	}

	public void agregarMovimiento(Compra cmp) {
		setSaldoActual(getSaldoActual() - (cmp.getMonto()*cmp.getCotizacion()));
		this.getMovimientos().add(cmp);
		cmp.setCuenta(this);
	}
}
