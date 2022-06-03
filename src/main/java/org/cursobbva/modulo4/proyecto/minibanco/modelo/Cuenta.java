package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

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
	@NotNull(message = "{cuenta.fechaCreacion}")
	@PastOrPresent(message = "{cuenta.fechaCreacion.pasado}")
	@Column(updatable=false)
	private LocalDate fechaDeCreacion;
	@PositiveOrZero(message = "{cuenta.saldoInicial}")
	@Column(updatable=false)
	private float saldoInicial;
	@PositiveOrZero(message = "{cuenta.saldoActual}")
	private float saldoActual;
	@PositiveOrZero(message = "{cuenta.descubiertoAcordado}")
	private float descubiertoAcordado;
	private LocalDate fechaDeCierre;
	@ManyToOne
	@JoinColumn(name="titular_Id", updatable=false)
	@NotNull(message = "{cuenta.titular}")
	private Cliente titular;
	@ManyToMany
	private Set<Cliente> cotitulares = new HashSet<Cliente>();
	@OneToMany(fetch = FetchType.EAGER)//(mappedBy = "cuenta")
	private List<Movimiento> movimientos = new ArrayList<Movimiento>();


	//CONSTRUCTORES
	public Cuenta(LocalDate fechaDeCreacion, float saldoInicial, float saldoActual, float descubiertoAcordado,
			LocalDate fechaDeCierre, Cliente titular) {
		super();
		this.fechaDeCreacion = fechaDeCreacion;
		this.saldoInicial = saldoInicial;
		this.saldoActual = saldoInicial;
		this.descubiertoAcordado = descubiertoAcordado;
		this.fechaDeCierre = fechaDeCierre;
		this.titular = titular;
	}
	public Cuenta() {}
	
	//GETTERS Y SETTERS	
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public LocalDate getFechaDeCreacion() {
		return fechaDeCreacion;
	}
	public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
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

	
	//AGREGAR
	public void agregarCotitular(Cliente cotitular) {
		cotitulares.add(cotitular);
	}
	
	public void agregarMovimiento(Movimiento movimiento) {
		movimientos.add(movimiento);
	}

	public void agregarMovimiento(TransferenciaCredito trfcrdt) {
		saldoActual = saldoActual + trfcrdt.getMonto();
		movimientos.add(trfcrdt);
	}
	
	public void agregarMovimiento(TransferenciaDebito trfdbt) {
		saldoActual = saldoActual - trfdbt.getMonto();
		movimientos.add(trfdbt);
	}

	public abstract void agregarMovimiento(Venta vta);
	
	public TipoMoneda getMoneda() {
		return null;
	}
	
}
