package org.cursobbva.modulo4.proyecto.minibanco.uso;


import java.time.LocalDate;

import javax.annotation.Resource;

import org.cursobbva.modulo4.proyecto.minibanco.daos.ClienteDAO;
import org.cursobbva.modulo4.proyecto.minibanco.daos.CuentaDAO;
import org.cursobbva.modulo4.proyecto.minibanco.daos.MovimientoDAO;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaExtranjera;
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
		System.out.println("Inicio Persistencia DAO...");
		
		Direccion dir1 = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
		Cliente cte1 = new Cliente("nombrecte1", "apellido", "telefono", "email", dir1);
		clienteDao.create(cte1);
		Cuenta ctaext1 = new CuentaExtranjera(LocalDate.now(), 0F, 0F, 1000F, LocalDate.now(), cte1, TipoMoneda.DOLAR);
		cuentaDao.create(ctaext1);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/contexto-jpa.xml");
		UsoMinibancoPersistenciaDAOSpring um = ctx.getBean("usoMinibancoPersistenciaDAOSpring",UsoMinibancoPersistenciaDAOSpring.class);
		um.usar();
		
		((ConfigurableApplicationContext) ctx).close();

		
		System.out.println("Fin Persistencia DAO...");
 
		
	}

}

