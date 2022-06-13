package org.cursobbva.modulo4.proyecto.minibanco.servicio;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.cursobbva.modulo4.proyecto.minibanco.dao.ClienteDAO;
import org.cursobbva.modulo4.proyecto.minibanco.dao.CuentaDAO;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaExtranjera;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaLocal;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author Cristian Gutierrez
 *
 */

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
			cuenta = new CuentaLocal(LocalDate.now(), saldoInicial, 0.0, 0.0, null, titular);
		} else {
			cuenta = new CuentaExtranjera(LocalDate.now(), saldoInicial, 0.0, 0.0, null, titular, moneda);
		}
		return cuentaDao.create(cuenta);
	}

	@Transactional
	public Cuenta leerCuentaById(Long idCuenta) {
		Cuenta cta = cuentaDao.read(idCuenta); 
		if (cta != null) {return cta;}
		else {
			throw new IllegalArgumentException("Cuenta Inexistente");
		}
		
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
		return cta;
	}
	
}
