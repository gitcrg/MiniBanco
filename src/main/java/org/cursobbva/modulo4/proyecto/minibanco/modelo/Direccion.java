package org.cursobbva.modulo4.proyecto.minibanco.modelo;

public class Direccion {
	
	private String calle;
	private String numero;
	private String departamento;
	private String piso;
	private String ciudad;
	private String codigoPostal;
	private String provincia;
	
	public Direccion(String calle, String numero, String departamento, String piso, String ciudad, String codigoPostal,
			String provincia) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.departamento = departamento;
		this.piso = piso;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	
}
