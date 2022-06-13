package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  
 * @author Cristian Gutierrez
 *
 */

@Entity(name = "CLIENTES")
@NamedQueries({
@NamedQuery(name="CLIENTES.buscarPorNombre", query="select cte from CLIENTES cte where cte.nombre=:nombre"),
@NamedQuery(name="CLIENTES.buscarTodos", query="select cte from CLIENTES cte")
})
@Data
@NoArgsConstructor
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "{cliente.nombre}")
	@Column(nullable = false)
	private String nombre;
	@NotEmpty(message = "{cliente.apellido}")
	@Column(nullable = false)
	private String apellido;
	private String telefono;
	@Email(message = "{cliente.email}")
	private String email;
	@Embedded
	@NotNull(message = "{cliente.direccion}")
	private Direccion direccion;
	@OneToMany (mappedBy = "titular")
	private List<Cuenta> cuentasTitular = new ArrayList<Cuenta>();
	@ManyToMany (mappedBy = "cotitulares")
	private List<Cuenta> cuentasCoTitular = new ArrayList<Cuenta>();
	
	public Cliente(String nombre, String apellido, String telefono, String email, Direccion direccion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
	}

	public boolean esTitular(Cuenta cuenta) {
		return cuentasTitular.contains(cuenta);
	}
	
	public void agregarCuentaTitular(Cuenta cuentaTitular) {
		if (esTitular(cuentaTitular)) {
			throw new IllegalArgumentException("Cliente ya es titular de la cuenta");
		} else {
			cuentasTitular.add(cuentaTitular);			
		}
	}	

	public boolean esCoTitular(Cuenta cuenta) {
		return cuentasCoTitular.contains(cuenta);
	}
	
	public void agregarCuentaCoTitular(Cuenta cuentaCoTitular) {
		if (esCoTitular(cuentaCoTitular)) {
			throw new IllegalArgumentException("Cliente ya es cotitular de la cuenta");
		} else {
			cuentasCoTitular.add(cuentaCoTitular);			
		}
	}	

	public void quitarCuentaCoTitular(Cuenta cuentaCoTitular) {
		if (!esCoTitular(cuentaCoTitular)) {
			throw new IllegalArgumentException("Cliente no es cotitular de la cuenta");
		} else {
			cuentasCoTitular.remove(cuentaCoTitular);			
		}
	}	
	
	public boolean cuentaDelCliente(Cuenta cta) {
//		return this.esTitular(cta) || this.esCoTitular(cta);
		boolean resp = false;
		for (int i=0;i<cuentasTitular.size();i++) {
			if (cuentasTitular.get(i).getNumero() == cta.getNumero()){
				resp = true;
			}
	    }
		for (int i=0;i<cuentasCoTitular.size();i++) {
			if (cuentasCoTitular.get(i).getNumero() == cta.getNumero()){
				resp = true;
			}
	    }
		return resp;
	}
	
	@PrePersist
	@PreUpdate
	private void validate() {
		if (nombre == null || nombre.isEmpty())
			throw new IllegalArgumentException("Nombre Invalido");
		if (apellido == null || apellido.isEmpty())
			throw new IllegalArgumentException("Apellido Invalido");

	}

	
}
