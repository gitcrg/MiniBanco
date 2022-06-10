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
import javax.validation.ConstraintViolation;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

	public void agregarCuentaTitular(Cuenta cuentaTitular) {
		if (cuentasTitular.contains(cuentaTitular)) {
			throw new IllegalArgumentException("Cliente ya es titular de la cuenta");
		} else {
			cuentasTitular.add(cuentaTitular);			
		}

	}	

	//VER si se puede eliminar este metodo. No es necesario para persistir
	public void agregarCuentaCoTitular(Cuenta cuentaCoTitular) {
		if (cuentasCoTitular.contains(cuentaCoTitular)) {
			throw new IllegalArgumentException("Cliente ya es cotitular de la cuenta");
		} else {
			cuentasCoTitular.add(cuentaCoTitular);			
		}

	}	

	//VER si se puede eliminar este metodo. No es necesario para persistir
	public void quitarCuentaCoTitular(Cuenta cuentaCoTitular) {
		if (!cuentasCoTitular.contains(cuentaCoTitular)) {
			throw new IllegalArgumentException("Cliente no es cotitular de la cuenta");
		} else {
			cuentasCoTitular.remove(cuentaCoTitular);			
		}

	}	
	
	public boolean cuentaDelCliente(Cuenta cta) {
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
