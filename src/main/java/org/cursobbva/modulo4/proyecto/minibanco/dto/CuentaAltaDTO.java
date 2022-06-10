package org.cursobbva.modulo4.proyecto.minibanco.dto;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CuentaAltaDTO {
	private Double saldoInicial;
	private Double descubierto;
	private Long idCliente;
	private TipoMoneda moneda;

}
