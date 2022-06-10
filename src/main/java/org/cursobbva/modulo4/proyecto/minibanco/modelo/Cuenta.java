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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Entity(name = "CUENTAS")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
@NamedQuery(name="CUENTAS.buscarTodas", query="select cta from CUENTAS cta"),
})
@Data
@NoArgsConstructor
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
	private Double saldoInicial;
	@NotNull(message = "{cuenta.saldoActual}")
	private Double saldoActual;
	@PositiveOrZero(message = "{cuenta.descubiertoAcordado}")
	private Double descubiertoAcordado;
	private LocalDate fechaDeCierre;
	@ManyToOne
	@JoinColumn(name="titular_Id", updatable=false)
	@NotNull(message = "{cuenta.titular}")
	@JsonIgnore
	private Cliente titular;
	@ManyToMany
	@JsonIgnore
	private Set<Cliente> cotitulares = new HashSet<Cliente>();
	@OneToMany(mappedBy = "cuenta")
	private List<Movimiento> movimientos = new ArrayList<Movimiento>();

	public Cuenta(LocalDate fechaDeCreacion, Double saldoInicial, Double saldoActual, Double descubiertoAcordado, LocalDate fechaDeCierre, Cliente titular) {
		super();
		this.fechaDeCreacion = fechaDeCreacion;
		this.saldoInicial = saldoInicial;
		this.saldoActual = saldoInicial;
		this.descubiertoAcordado = descubiertoAcordado;
		this.fechaDeCierre = fechaDeCierre;
		this.titular = titular;
		if (titular != null)  titular.agregarCuentaTitular(this);
	}

	public void agregarCotitular(Cliente cotitular) {
		if (cotitulares.contains(cotitular)) {
			throw new IllegalArgumentException("Cliente ya es cotitular de la cuenta");
		} else {
			cotitulares.add(cotitular);		
		}
	
	}
	
	public void quitarCotitular(Cliente cotitular) {
		if (!cotitulares.contains(cotitular)) {
			throw new IllegalArgumentException("Cliente no es cotitular de la cuenta");
		} else {
			cotitulares.remove(cotitular);		
		}
	
	}
	
	public void agregarMovimiento(Movimiento movimiento) {
		movimientos.add(movimiento);
		movimiento.setCuenta(this);
	}

	public void agregarMovimiento(TransferenciaCredito trfcrdt) {
		saldoActual = saldoActual + trfcrdt.getMonto();
		movimientos.add(trfcrdt);
		trfcrdt.setCuenta(this);
	}
	
	public void agregarMovimiento(TransferenciaDebito trfdbt) {
		saldoActual = saldoActual - trfdbt.getMonto();
		movimientos.add(trfdbt);
		trfdbt.setCuenta(this);
	}

	public abstract void agregarMovimiento(Venta vta);
	
	public TipoMoneda getMoneda() {
		return null;
	}
	
	
	public boolean cuentaAbierta() {
		return fechaDeCierre == null;
	}
	
	
}
