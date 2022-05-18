package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
/**
 * 
 * @author Cristian Gutierrez
 *
 */
@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	@Embedded
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
	public Cliente() {}

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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
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

	public List<Cuenta> getCuentasTitular() {
		return cuentasTitular;
	}

	public void setCuentasTitular(List<Cuenta> cuentasTitular) {
		this.cuentasTitular = cuentasTitular;
	}

	public List<Cuenta> getCuentasCoTitular() {
		return cuentasCoTitular;
	}

	public void setCuentasCoTitular(List<Cuenta> cuentasCoTitular) {
		this.cuentasCoTitular = cuentasCoTitular;
	}

	public void agregarCuentaTitular(Cuenta cuenta) {
		cuentasTitular.add(cuenta);
	}
	
	public void agregarCuentaCoTitular(Cuenta cuenta) {
		cuentasCoTitular.add(cuenta);
	}
	
}