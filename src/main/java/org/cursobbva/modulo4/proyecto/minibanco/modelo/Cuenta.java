package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
/**
 * 
 * @author Cristian Gutierrez
 *
 */
@Entity
public abstract class Cuenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	private LocalDate fechaDeCreacion;
	private float saldoInicial;
	private float saldoActual;
	private float descubiertoAcordado;
	private LocalDate fechaDeCierre;
	@ManyToOne
	private Cliente titular;
	@ManyToMany
	private Set<Cliente> cotitulares = new HashSet<Cliente>();
	@OneToMany
	@JoinColumn (name ="cuenta_id")
	private List<Movimiento> movimientos = new ArrayList<Movimiento>();

	public Cuenta(Long numero, LocalDate fechaDeCreacion, float saldoInicial, float saldoActual,
			float descubiertoAcordado, LocalDate fechaDeCierre, Cliente titular) {
		super();
		this.numero = numero;
		this.fechaDeCreacion = fechaDeCreacion;
		this.saldoInicial = saldoInicial;
		this.saldoActual = saldoActual;
		this.saldoActual = saldoInicial;
		this.descubiertoAcordado = descubiertoAcordado;
		this.fechaDeCierre = fechaDeCierre;
		this.titular = titular;
	}
	public Cuenta() {}

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

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public Set<Cliente> getCotitulares() {
		return cotitulares;
	}

	public void setCotitulares(Set<Cliente> cotitulares) {
		this.cotitulares = cotitulares;
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	
	public void agregarCotitular(Cliente cotitular) {
		cotitulares.add(cotitular);
	}

	public void agregarMovimiento(Movimiento movimiento) {
		movimientos.add(movimiento);
	}
	
}
