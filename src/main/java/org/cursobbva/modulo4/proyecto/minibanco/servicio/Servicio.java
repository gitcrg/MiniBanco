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
public class Servicio {
	
	@Resource(name = "clienteDAO")
	private ClienteDAO clienteDao;

	@Resource(name = "cuentaDAO")
	private CuentaDAO cuentaDao;

	@Resource(name = "movimientoDAO")
	private MovimientoDAO movimientoDao;

	@Autowired
	private ServicioCambioImplem servicioCambio;
	
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
			throw new IllegalArgumentException("cliente inexistente.");
		}
		cliente.setDireccion(nuevaDireccion);

	}

	
	
	
	
	
	@Transactional
	public Cuenta altaCuenta(Double saldoInicial, Double descubiertoAcordado,	Long idTitular, TipoMoneda moneda) {
		Cliente titular = clienteDao.read(idTitular);
		
		if (titular.getId() == null) {
			throw new IllegalArgumentException("El cliente no existe.");
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
	public Cuenta leerCuentaById(long idCuenta) {
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
			throw new IllegalArgumentException("CLIENTE IONEXISTENTE");
		}		
		
		if (cta == null) {			
			throw new IllegalArgumentException("CUENTA IONEXISTENTE");
		}		
		
		if (!cta.cuentaAbierta()) {			
			throw new IllegalArgumentException("CUENTA CERRADA");
		}
		if (cta.getTitular().getId() == cte.getId()) {
			throw new IllegalArgumentException("EL CLIENTE YA ES TITULAR DE LA CUENTA");
		}
		cotitulares = cta.getCotitulares();
		for(Cliente c : cotitulares){ 
			if(c.getId() == cte.getId())
			throw new IllegalArgumentException("EL CLIENTE YA ES COTITULAR DE LA CUENTA");
		}
		
		cta.agregarCotitular(cte);
//		cte.agregarCuentaCoTitular(cta);
		return cta;
		
	}

	
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
			System.out.println("CUENTA ORIGEN CERRADA...");
			throw new IllegalArgumentException("CUENTA ORIGEN CERRADA");
		}
		
		if (!destino.cuentaAbierta()) {			
			System.out.println("CUENTA Destino CERRADA...");
			throw new IllegalArgumentException("CUENTA Destino CERRADA");
		}
		
		if (origen.getMoneda() != destino.getMoneda()) {
			System.out.println("Cuentas de diferente moneda");
			throw new IllegalArgumentException("Cuentas de diferente moneda");
		}
		
		System.out.println("PASE LAS VALIDACIONES !!!!!!!");
		
		TransferenciaCredito trfcrdt = new TransferenciaCredito(LocalDateTime.now(), monto, "Transferencia Recibida", origen);
		TransferenciaDebito trfdbt = new TransferenciaDebito(LocalDateTime.now(), monto, "Transferencia Efectuada", destino);

		System.out.println("GENERE LOS MOVIMIENTOS !!!!!!!");
		
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

		if (!cliente.cuentaDelCliente(origen) || !cliente.cuentaDelCliente(origen)) {
			throw new IllegalArgumentException("Las cuentas deben ser del cliente");
		}
				
		if ((origen.getSaldoActual() + origen.getDescubiertoAcordado()) < monto ) {
			throw new IllegalArgumentException("Saldo insuficiente");
		}

		if (!origen.cuentaAbierta()) {			
			System.out.println("CUENTA ORIGEN CERRADA...");
			throw new IllegalArgumentException("CUENTA ORIGEN CERRADA");
		}
		
		if (!destino.cuentaAbierta()) {			
			System.out.println("CUENTA Destino CERRADA...");
			throw new IllegalArgumentException("CUENTA Destino CERRADA");
		}
		
		if (origen.getMoneda() == null) {
			System.out.println("Cuenta origen debe ser Extranjera");
			throw new IllegalArgumentException("Cuenta origen debe ser Extranjera");
		}
		
		if (destino.getMoneda() != null) {
			System.out.println("Cuenta destino debe ser Local");
			throw new IllegalArgumentException("Cuenta destino debe ser Local");
		}
		
		System.out.println("PASE LAS VALIDACIONES !!!!!!!");
		
//		ResultadoCambioImplem resultadoCambio = (ResultadoCambioImplem) servicioCambio.cambiar(origen.getMoneda(), destino.getMoneda(), monto);
		ResultadoCambio resultadoCambio = (ResultadoCambio) servicioCambio.cambiar(origen.getMoneda(), destino.getMoneda(), monto);
		
		System.out.println(resultadoCambio.getTasa());
		System.out.println("HICE EL CAMBIO !!!!!!!");
		
		Venta vtadbt = new Venta(LocalDateTime.now(), monto, "Debito Venta de moneda extranjera", resultadoCambio.getTasa(), 0D);
		Venta vtacrdt = new Venta(LocalDateTime.now(), monto*resultadoCambio.getTasa(), "Credito Venta de moneda extranjera", resultadoCambio.getTasa(), 0D);
		
		System.out.println("GENERE LOS MOVIMIENTOS !!!!!!!");
		

		origen.agregarMovimiento(vtadbt);
		destino.agregarMovimiento(vtacrdt);

		movimientoDao.create(vtadbt);
		movimientoDao.create(vtacrdt);
		
		cuentaDao.update(origen);
		cuentaDao.update(destino);
		
	}


	
	
	

}
