package org.cursobbva.modulo4.proyecto.minibanco.test;

import static org.junit.jupiter.api.Assertions.*;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.cursobbva.modulo4.proyecto.minibanco.servicio.ServicioCliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

/**
 * TEST para Alta de Cliente y Cambio de Direccion
 * @author Cristian Gutierrez
 *
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:/spring/contexto-jpa-test.xml")
@Transactional
class ClienteServicioTest {
	@Autowired
	private ServicioCliente servicioCliente;
	
	@BeforeEach
	public void inicioCadaTest() {

	}

	@Test
	public void testAltaCliente() {
		Direccion dir = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
		Cliente cte = servicioCliente.altaCliente("nombre", "apellido", "telefono", "email@email.com", dir);
		assertEquals("nombre", cte.getNombre());
		assertEquals("apellido", cte.getApellido());
	}

	
	@Test
	public void testClienteById() {
		Cliente cte = servicioCliente.leerClienteById(1L);
		assertEquals("nombre1", cte.getNombre());
	}

	@Test
	public void testClienteInexistente() {
		IllegalArgumentException excep = assertThrows(IllegalArgumentException.class, () -> {servicioCliente.leerClienteById(0L);});
		assertEquals("Cliente Inexistente", excep.getMessage());
	}

	@Test
	public void testClienteCambioDireccion() {
		Direccion dir = new Direccion("nueva calle", "nro", "dtp", "", "ciudad1", "cp", "provincia");
		
		Cliente cte = servicioCliente.leerClienteById(1L);
		cte.setDireccion(dir);
		Cliente cte1 = servicioCliente.leerClienteById(1L);
		
		assertEquals("nueva calle", cte1.getDireccion().getCalle());
		assertEquals("nro", cte1.getDireccion().getNumero());
		assertEquals("dtp", cte1.getDireccion().getDepartamento());
		assertEquals("", cte1.getDireccion().getPiso());
		assertEquals("ciudad1", cte1.getDireccion().getCiudad());
		assertEquals("cp", cte1.getDireccion().getCodigoPostal());
		assertEquals("provincia", cte1.getDireccion().getProvincia());
	}
}

