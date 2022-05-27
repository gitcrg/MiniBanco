package org.cursobbva.modulo4.proyecto.minibanco.servicios;

import java.time.LocalDate;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;

import org.cursobbva.modulo4.proyecto.minibanco.daos.ClienteDAO;
import org.cursobbva.modulo4.proyecto.minibanco.daos.CuentaDAO;
import org.cursobbva.modulo4.proyecto.minibanco.daos.MovimientoDAO;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaExtranjera;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;
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
	
	@Transactional
	public void trxAgregarCotitular(Long idCliente, Long idCuenta) {

		Cliente cte = clienteDao.read(idCliente);
		Cuenta cta = cuentaDao.read(idCuenta);
		Set<Cliente> cotitulares;

		if (cta.getFechaDeCierre() != null) {
			System.out.println("CUENTA CERRADA...");
		}
		if (cta.getTitular().getId() == cte.getId()) {
			System.out.println("EL CLIENTE YA ES TITULAR DE LA CUENTA...");
		}

		cotitulares = cta.getCotitulares();
		for(Cliente c : cotitulares){
			if(c.getId() == cta.getTitular().getId())
			System.out.println("EL CLIENTE YA ES COTITULAR");
		}

		
		cta.agregarCotitular(cte);

		
	}
	
	public void agregarCotitular(Long idCliente, Long idCuenta) {
		// TODO Auto-generated method stub

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/contexto-jpa.xml");
		Servicio um = ctx.getBean("servicio",Servicio.class);
		um.trxAgregarCotitular(idCliente,idCuenta);
		
		((ConfigurableApplicationContext) ctx).close();
		
	}


}
