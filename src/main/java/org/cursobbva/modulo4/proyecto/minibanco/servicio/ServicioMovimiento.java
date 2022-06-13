package org.cursobbva.modulo4.proyecto.minibanco.servicio;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.cursobbva.modulo4.proyecto.minibanco.dao.ClienteDAO;
import org.cursobbva.modulo4.proyecto.minibanco.dao.CuentaDAO;
import org.cursobbva.modulo4.proyecto.minibanco.dao.MovimientoDAO;
import org.cursobbva.modulo4.proyecto.minibanco.implem.ServicioCambioImplem;
import org.cursobbva.modulo4.proyecto.minibanco.interf.ResultadoCambio;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Movimiento;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TransferenciaCredito;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TransferenciaDebito;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Component
public class ServicioMovimiento {
	
	@Resource(name = "clienteDAO")
	private ClienteDAO clienteDao;

	@Resource(name = "cuentaDAO")
	private CuentaDAO cuentaDao;

	@Resource(name = "movimientoDAO")
	private MovimientoDAO movimientoDao;

	@Autowired
	private ServicioCambioImplem servicioCambio;
	
	@Transactional
	public void transferir(Long idOrigen, Long idDestino, Double monto) {

		Cuenta origen = cuentaDao.read(idOrigen);
		Cuenta destino = cuentaDao.read(idDestino);
		
		if (monto <= 0) {
			throw new IllegalArgumentException("Monto de transferencia debe ser mayor a CERO");
		}
		
		if (origen == null) {
			throw new IllegalArgumentException("Cuenta Origen inexistente");
		}

		if (destino == null) {
			throw new IllegalArgumentException("Cuenta Destino inexistente");
		}

		if ((origen.getSaldoActual() + origen.getDescubiertoAcordado()) < monto ) {
			throw new IllegalArgumentException("Saldo insuficiente");
		}
		
		if (!origen.cuentaAbierta()) {			
			throw new IllegalArgumentException("Cuenta origen cerrada");
		}
		
		if (!destino.cuentaAbierta()) {			
			throw new IllegalArgumentException("Cuenta destino cerrada");
		}
		
		if (origen.getMoneda() != destino.getMoneda()) {
			throw new IllegalArgumentException("Cuentas de diferente moneda");
		}
		
		TransferenciaCredito trfcrdt = new TransferenciaCredito(LocalDateTime.now(), monto, "Transferencia Recibida", origen);
		TransferenciaDebito trfdbt = new TransferenciaDebito(LocalDateTime.now(), monto, "Transferencia Efectuada", destino);

		origen.agregarMovimiento(trfdbt);
		destino.agregarMovimiento(trfcrdt);

		movimientoDao.create(trfcrdt);
		movimientoDao.create(trfdbt);
		
		cuentaDao.update(origen);
		cuentaDao.update(destino);
		
	}

	@Transactional
	public void vender(Long idCliente, Long idOrigen, Long idDestino, Double monto) {

		Cliente cliente = clienteDao.read(idCliente);
		Cuenta origen = cuentaDao.read(idOrigen);
		Cuenta destino = cuentaDao.read(idDestino);
		
		if (monto <= 0) {
			throw new IllegalArgumentException("Monto de venta debe ser mayor a CERO");
		}

		if (cliente == null) {
			throw new IllegalArgumentException("Cliente inexistente");
		}

		if (origen == null) {
			throw new IllegalArgumentException("Cuenta Origen inexistente");
		}

		if (destino == null) {
			throw new IllegalArgumentException("Cuenta Destino inexistente");
		}

		if (!cliente.cuentaDelCliente(origen) || !cliente.cuentaDelCliente(destino)) {
			throw new IllegalArgumentException("Las cuentas deben ser del cliente");
		}

		if ((origen.getSaldoActual() + origen.getDescubiertoAcordado()) < monto ) {
			throw new IllegalArgumentException("Saldo insuficiente");
		}

		if (!origen.cuentaAbierta()) {			
			throw new IllegalArgumentException("Cuenta origen cerrada");
		}
		
		if (!destino.cuentaAbierta()) {			
			throw new IllegalArgumentException("Cuenta destino cerrada");
		}
		
		if (origen.getMoneda() == null) {
			throw new IllegalArgumentException("Cuenta origen debe ser Extranjera");
		}
		
		if (destino.getMoneda() != null) {
			throw new IllegalArgumentException("Cuenta destino debe ser Local");
		}
		
		ResultadoCambio resultadoCambio = (ResultadoCambio) servicioCambio.cambiar(origen.getMoneda(), destino.getMoneda(), monto);
		
		Venta vtadbt = new Venta(LocalDateTime.now(), monto, "Debito Venta de moneda extranjera", resultadoCambio.getTasa(), 0.0);
		Venta vtacrdt = new Venta(LocalDateTime.now(), resultadoCambio.getResultado(), "Credito Venta de moneda extranjera", resultadoCambio.getTasa(), 0.0);
		
		origen.agregarMovimiento(vtadbt);
		destino.agregarMovimiento(vtacrdt);

		movimientoDao.create(vtadbt);
		movimientoDao.create(vtacrdt);
		
		cuentaDao.update(origen);
		cuentaDao.update(destino);
		
	}

	@Transactional
	public List<Movimiento> listarMovimientos(Long idCuenta) {
		return (List<Movimiento>) movimientoDao.getMovimientosPorCuenta(idCuenta);
	}


}
