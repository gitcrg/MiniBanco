package org.cursobbva.modulo4.proyecto.minibanco.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cursobbva.modulo4.proyecto.minibanco.dao.ClienteDAO;
import org.cursobbva.modulo4.proyecto.minibanco.dao.CuentaDAO;
import org.cursobbva.modulo4.proyecto.minibanco.implem.ServicioCambioImplem;
import org.cursobbva.modulo4.proyecto.minibanco.interf.ResultadoCambio;
import org.cursobbva.modulo4.proyecto.minibanco.interf.ServicioCambio;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;
import org.cursobbva.modulo4.proyecto.minibanco.servicio.ServicioCuenta;
import org.cursobbva.modulo4.proyecto.minibanco.servicio.ServicioMovimiento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Cristian Gutierrez
 *
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:/spring/contexto-jpa-test.xml")
@Transactional
class CambioServicioTest {
	@Autowired
	ServicioCambio servicioCambio;
	
	@BeforeEach
	public void inicioCadaTest() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void CalculoOK() {
	
	ResultadoCambio resultadoCambio = (ResultadoCambio) servicioCambio.cambiar(TipoMoneda.USD, TipoMoneda.ARS, 1000.0);

	assertEquals(resultadoCambio.getResultado(), resultadoCambio.getTasa()*1000.0);
	
	}
}
