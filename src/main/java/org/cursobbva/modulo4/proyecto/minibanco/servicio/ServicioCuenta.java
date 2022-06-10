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
public class ServicioCuenta {
	
	@Resource(name = "clienteDAO")
	private ClienteDAO clienteDao;

	@Resource(name = "cuentaDAO")
	private CuentaDAO cuentaDao;
	
	@Transactional
	public Cuenta altaCuenta(Double saldoInicial, Double descubiertoAcordado, Long idTitular, TipoMoneda moneda) {
		Cliente titular = clienteDao.read(idTitular);
		
		if (titular.getId() == null) {
			throw new IllegalArgumentException("El cliente titular no existe.");
		}
		Cuenta cuenta;
		if (moneda == null) {
			cuenta = new CuentaLocal(LocalDate.now(), saldoInicial, 0D, 0D, null, titular);
		} else {
			cuenta = new CuentaExtranjera(LocalDate.now(), saldoInicial, 0D, 0D, null, titular, moneda);
		}
		return cuentaDao.create(cuenta);
	}

	@Transactional
	public Cuenta leerCuentaById(Long idCuenta) {
		return cuentaDao.read(idCuenta);
	}
	
	@Transactional
	public List<Cuenta> listarCuentas() {
		return (List<Cuenta>) cuentaDao.readAll();
	}
	
	@Transactional
	public Cuenta agregarCotitular(Long idCliente, Long idCuenta) {

		Cliente cte = clienteDao.read(idCliente);
		Cuenta cta = cuentaDao.read(idCuenta);
		Set<Cliente> cotitulares;

		if (cte == null) {			
			throw new IllegalArgumentException("Cliente Inexistente");
		}		
		
		if (cta == null) {			
			throw new IllegalArgumentException("Cuenta Inexistente");
		}		
		
		if (!cta.cuentaAbierta()) {			
			throw new IllegalArgumentException("Cuenta cerrada");
		}
		if (cta.getTitular().getId() == cte.getId()) {
			throw new IllegalArgumentException("El cliente ya es titular de la cuenta");
		}
		cotitulares = cta.getCotitulares();
		for(Cliente c : cotitulares){ 
			if(c.getId() == cte.getId())
			throw new IllegalArgumentException("El cliente ya es cotitular de la cuenta");
		}
		
		cta.agregarCotitular(cte);
//		cte.agregarCuentaCoTitular(cta);
		return cta;
	}
	
}
