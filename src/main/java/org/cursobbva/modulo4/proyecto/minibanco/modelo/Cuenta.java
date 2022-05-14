package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Cuenta {
	
	private Long numero;
	private LocalDate fechaDeCreacion;
	private float saldoInicial;
	private float saldoActual;
	private float descubiertoAcordado;
	private LocalDate fechaDeCierre;

	private ClienteTitular titular;
	
	private Set<ClienteCoTitular> cotitulares = new HashSet<ClienteCoTitular>();
	
	private List<Movimiento> movimientos = new ArrayList<Movimiento>();

	public Cuenta(Long numero, LocalDate fechaDeCreacion, float saldoInicial, float saldoActual,
			float descubiertoAcordado, LocalDate fechaDeCierre, ClienteTitular titular) {
		super();
		this.numero = numero;
		this.fechaDeCreacion = fechaDeCreacion;
		this.saldoInicial = saldoInicial;
//		this.saldoActual = saldoActual;
		this.saldoActual = saldoInicial;
		this.descubiertoAcordado = descubiertoAcordado;
		this.fechaDeCierre = fechaDeCierre;
		this.titular = titular;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public LocalDate getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(LocalDate fechaDeCreación) {
		this.fechaDeCreacion = fechaDeCreación;
	}

	public float getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(float saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public float getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(float saldoActual) {
		this.saldoActual = saldoActual;
	}

	public float getDescubiertoAcordado() {
		return descubiertoAcordado;
	}

	public void setDescubiertoAcordado(float descubiertoAcordado) {
		this.descubiertoAcordado = descubiertoAcordado;
	}

	public LocalDate getFechaDeCierre() {
		return fechaDeCierre;
	}

	public void setFechaDeCierre(LocalDate fechaDeCierre) {
		this.fechaDeCierre = fechaDeCierre;
	}

	public ClienteTitular getTitular() {
		return titular;
	}

	public void setTitular(ClienteTitular titular) {
		this.titular = titular;
	}

	public Set<ClienteCoTitular> getCotitulares() {
		return cotitulares;
	}

	public void setCotitulares(Set<ClienteCoTitular> cotitulares) {
		this.cotitulares = cotitulares;
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	
	public void agregarCotitular(ClienteCoTitular cotitular) {
		cotitulares.add(cotitular);
	}

	public void agregarMovimiento(Movimiento movimiento) {
		movimientos.add(movimiento);
	}
	
}
