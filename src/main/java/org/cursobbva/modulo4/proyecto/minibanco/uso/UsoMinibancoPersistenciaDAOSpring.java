package org.cursobbva.modulo4.proyecto.minibanco.uso;


import java.time.LocalDate;

import javax.annotation.Resource;

import org.cursobbva.modulo4.proyecto.minibanco.dao.ClienteDAO;
import org.cursobbva.modulo4.proyecto.minibanco.dao.CuentaDAO;
import org.cursobbva.modulo4.proyecto.minibanco.dao.MovimientoDAO;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaExtranjera;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaLocal;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UsoMinibancoPersistenciaDAOSpring {
	
	@Resource(name = "clienteDAO")
	private ClienteDAO clienteDao;

	@Resource(name = "cuentaDAO")
	private CuentaDAO cuentaDao;
	
	@Resource(name = "movimientoDAO")
	private MovimientoDAO movimientoDao;
	
	@Transactional
	public void usar() {
	
		Direccion dir1 = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
		Cliente cte1 = new Cliente("nombrecte1", "apellido1", "telefono1", "email1@email.com", dir1);
		clienteDao.create(cte1);
		Cliente cte2 = new Cliente("nombrecte2", "apellido2", "telefono2", "email2@email.com", dir1);
		clienteDao.create(cte2);
		Cuenta ctaext1 = new CuentaExtranjera(LocalDate.now(), 0D, 0D, 1000D, LocalDate.now(), cte1, TipoMoneda.USD);
		cuentaDao.create(ctaext1);
		Cuenta ctaloc1 = new CuentaLocal(LocalDate.now(), 0D, 0D, 1000D, LocalDate.now(), cte1);
		cuentaDao.create(ctaloc1);
		
	}

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/contexto-jpa2.xml");
		UsoMinibancoPersistenciaDAOSpring um = ctx.getBean("usoMinibancoPersistenciaDAOSpring",UsoMinibancoPersistenciaDAOSpring.class);
		um.usar();
		
		((ConfigurableApplicationContext) ctx).close();

		
	}

}

