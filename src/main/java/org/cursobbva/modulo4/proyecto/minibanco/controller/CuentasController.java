package org.cursobbva.modulo4.proyecto.minibanco.controller;

import java.util.List;

import org.cursobbva.modulo4.proyecto.minibanco.dto.CuentaAltaDTO;
import org.cursobbva.modulo4.proyecto.minibanco.dto.CuentaCotitularDTO;
import org.cursobbva.modulo4.proyecto.minibanco.dto.TransferenciaDTO;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Movimiento;
import org.cursobbva.modulo4.proyecto.minibanco.servicio.Servicio;
import org.cursobbva.modulo4.proyecto.minibanco.servicio.ServicioCuenta;
import org.cursobbva.modulo4.proyecto.minibanco.servicio.ServicioMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/cuentas")
public class CuentasController {

	@Autowired
	ServicioCuenta servicioCuenta;

	@Autowired
	ServicioMovimiento servicioMovimiento;
	
	@GetMapping("/")
	public List<Cuenta> listar() {
		return servicioCuenta.listarCuentas();
	}

	@PostMapping("/alta")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cuenta> alta(@RequestBody CuentaAltaDTO cuentaAlta) {
		try {
			Cuenta cuenta = servicioCuenta.altaCuenta(cuentaAlta.getSaldoInicial(), cuentaAlta.getDescubierto(), cuentaAlta.getIdCliente(), cuentaAlta.getMoneda());

			if (cuenta != null) {
				return new ResponseEntity<>(cuenta, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		return null;
	}

	
	@PostMapping("/agregarCotitular")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<Cuenta> agregarCotitular(@RequestBody CuentaCotitularDTO cuentacotitular) {
		try {
			Cuenta cta = servicioCuenta.agregarCotitular(cuentacotitular.getIdCliente(), cuentacotitular.getIdCuenta());
			return new ResponseEntity<>(cta, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PostMapping("/transferir")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void transferirMismoBanco(@RequestBody TransferenciaDTO transferir) {
		try {
			servicioMovimiento.transferir(transferir.getIdCtaOrigen(), transferir.getIdCtaDestino(), transferir.getMonto());
		} catch (Exception e) {
			e.printStackTrace();
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping("/movimientos/{idCuenta}")
	public List<Movimiento> listarMovimientos(@PathVariable Long idCuenta) {
		return servicioMovimiento.listarMovimientos(idCuenta);
	}


}
