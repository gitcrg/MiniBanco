package org.cursobbva.modulo4.proyecto.minibanco.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferenciaDTO {
	private Long idCtaOrigen;
	private Long idCtaDestino;
	private Double monto;

}
