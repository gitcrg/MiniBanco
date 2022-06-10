package org.cursobbva.modulo4.proyecto.minibanco.servicio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;

import org.cursobbva.modulo4.proyecto.minibanco.dao.ClienteDAO;
import org.cursobbva.modulo4.proyecto.minibanco.dao.CuentaDAO;
import org.cursobbva.modulo4.proyecto.minibanco.dao.MovimientoDAO;
import org.cursobbva.modulo4.proyecto.minibanco.implem.ResultadoCambioImplem;
import org.cursobbva.modulo4.proyecto.minibanco.implem.ServicioCambioImplem;
import org.cursobbva.modulo4.proyecto.minibanco.interf.ResultadoCambio;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaExtranjera;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaLocal;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TransferenciaCredito;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TransferenciaDebito;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Venta;
import org.cursobbva.modulo4.proyecto.minibanco.uso.UsoMinibancoPersistenciaDAOSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class ServicioCliente {
	
	@Resource(name = "clienteDAO")
	private ClienteDAO clienteDao;
	
	@Transactional
	public void altaCliente(String nombre, String apellido, String telefono, String email, Direccion direccion) {
			Cliente cte = new Cliente(nombre, apellido, telefono, email, direccion);
			clienteDao.create(cte);
	}

	@Transactional
	public Cliente leerClienteById(long idCliente) {
		return clienteDao.read(idCliente);
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
