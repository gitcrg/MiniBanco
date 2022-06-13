package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Entity(name = "MOVIMIENTOS")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
@NamedQuery(name="MOVIMIENTOS.movimientoByCuenta", query="select mov from MOVIMIENTOS mov where mov.cuenta.numero=:idCuenta"),
})
@Data
@NoArgsConstructor
public abstract class Movimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "{movimiento.fechaHora}")
	@PastOrPresent(message = "{movimiento.fechaHora.pasado}")
	@Column(updatable=false)
	private LocalDateTime fechayHora;
	@Positive(message="{movimiento.monto}")
	@Column(updatable=false)
	private Double monto;
	@NotEmpty(message = "{movimiento.descripcion}")
	@Column(updatable=false)
	private String descripcion;
	@ManyToOne
	@JsonIgnore
    Cuenta cuenta;
	
	public Movimiento(LocalDateTime fechayHora, Double monto, String descripcion) {
		super();
		this.fechayHora = fechayHora;
		this.monto = monto;
		this.descripcion = descripcion;
	}
	
}
