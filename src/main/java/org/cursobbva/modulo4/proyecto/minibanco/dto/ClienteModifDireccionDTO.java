package org.cursobbva.modulo4.proyecto.minibanco.dto;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteModifDireccionDTO {
	private Long idCliente;
	private Direccion nuevaDirecc;
}
