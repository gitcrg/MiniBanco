package org.cursobbva.modulo4.proyecto.minibanco.dto;

import lombok.AllArgsConstructor;
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
public class CuentaCotitularDTO {
	private Long idCuenta;
	private Long idCliente;
}
