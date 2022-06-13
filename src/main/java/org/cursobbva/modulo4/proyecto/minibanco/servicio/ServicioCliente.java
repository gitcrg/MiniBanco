package org.cursobbva.modulo4.proyecto.minibanco.servicio;

import java.util.List;

import javax.annotation.Resource;

import org.cursobbva.modulo4.proyecto.minibanco.dao.ClienteDAO;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Component
public class ServicioCliente {
	
	@Resource(name = "clienteDAO")
	private ClienteDAO clienteDao;
	
	@Transactional
	public Cliente altaCliente(String nombre, String apellido, String telefono, String email, Direccion direccion) {
			Cliente cte = new Cliente(nombre, apellido, telefono, email, direccion);
			clienteDao.create(cte);
			return cte;
	}

	@Transactional
	public Cliente leerClienteById(Long idCliente) {
		Cliente cte = clienteDao.read(idCliente); 
		if (cte != null) {return cte;}
		else {
			throw new IllegalArgumentException("Cliente Inexistente");
		}
	}
	
	@Transactional
	public List<Cliente> listarClientes() {
		return (List<Cliente>) clienteDao.readAll();
	}
	
	@Transactional
	public List<Cliente> listarClientesNombre(String nombre) {
		return (List<Cliente>) clienteDao.getClientePorNombre(nombre);
	}
	
	@Transactional
	public void cambiarDireccionCliente(Long idCliente, Direccion nuevaDireccion) {
		Cliente cliente = clienteDao.read(idCliente);

		if (cliente == null) {
			throw new IllegalArgumentException("Cliente inexistente.");
		}
		cliente.setDireccion(nuevaDireccion);

	}

}
