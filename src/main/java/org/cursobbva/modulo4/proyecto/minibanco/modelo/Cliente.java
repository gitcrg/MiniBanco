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

/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Entity
@NamedQueries({
@NamedQuery(name="Cliente.clientesByNombre", query="select cte from Cliente cte where cte.nombre=:nombre"),
@NamedQuery(name="Cliente.clientesAll", query="select cte from Cliente cte")
})
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
//	@Email(message = "{cliente.email}")
	private String email;
	@Embedded
	@NotNull(message = "{cliente.direccion}")
	private Direccion direccion;
	@OneToMany (mappedBy = "titular")
	private List<Cuenta> cuentasTitular = new ArrayList<Cuenta>();
	@ManyToMany (mappedBy = "cotitulares")	
	private List<Cuenta> cuentasCoTitular = new ArrayList<Cuenta>();
	
	//CONSTRUCTORES
	public Cliente(String nombre, String apellido, String telefono, String email, Direccion direccion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
	}
	public Cliente() {}
	
	//GETTERS Y SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	

	//AGREGAR
	public void agregarCuentaTitular(Cuenta cuentaTitular) {
		cuentasTitular.add(cuentaTitular);
	}

	public void agregarCuentaCoTitular(Cuenta cuentaCoTitular) {
		cuentasCoTitular.add(cuentaCoTitular);
	}	

	public boolean cuentaDelCliente(Cuenta cta) {
		return this.cuentasTitular.contains(cta) || this.cuentasCoTitular.contains(cta);
	}
	
	//VALIDACIONES
	@PrePersist
	@PreUpdate
	private void validate() {
		if (nombre == null || nombre.isEmpty())
			throw new IllegalArgumentException("Nombre Invalido");
		if (apellido == null || apellido.isEmpty())
			throw new IllegalArgumentException("Apellido Invalido");

	}

	
}
