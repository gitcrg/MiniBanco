package org.cursobbva.modulo4.proyecto.minibanco.uso;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.cursobbva.modulo4.proyecto.minibanco.daos.ClienteDAO;
import org.cursobbva.modulo4.proyecto.minibanco.daos.CuentaDAO;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaExtranjera;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;

public class UsoMinibancoPersistenciaDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Inicio Persistencia DAO...");
		
		Direccion dir1 = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
		Direccion dir2 = new Direccion("calle2", "numero2", "departamento2", "piso2", "ciudad2", "codigoPostal2", "provincia2");
		Direccion dir3 = new Direccion("calle3", "numero3", "departamento3", "piso3", "ciudad3", "codigoPostal3", "provincia3");
		
		Cliente cte1 = new Cliente("nombrecte1", "apellido", "telefono", "email", dir1);
		Cliente cte2 = new Cliente("nombrecte2", "apellido", "telefono", "email", dir2);
		Cliente cte3 = new Cliente("nombrecte3", "apellido", "telefono", "email", dir3);
		Cliente cte4 = new Cliente("nombrecte3", "apellido", "telefono", "email", dir3);
		Cliente cte5 = new Cliente("nombrecte2", "apellido", "telefono", "email", dir3);
		Cliente cte6 = new Cliente("nombrecte3", "apellido", "telefono", "email", dir3);
		Cliente cte7 = new Cliente("nombrecte2", "apellido", "telefono", "email", dir3);
		
		Cuenta ctaext1 = new CuentaExtranjera(LocalDate.now(), 0F, 0F, 1000F, null, cte1, TipoMoneda.DOLAR);
		Cuenta ctaext2 = new CuentaExtranjera(LocalDate.now(), 0F, 0F, 1000F, null, cte1, TipoMoneda.DOLAR);
		Cuenta ctaext3 = new CuentaExtranjera(LocalDate.now(), 0F, 0F, 1000F, LocalDate.now(), cte1, TipoMoneda.DOLAR);
		Cuenta ctaext4 = new CuentaExtranjera(LocalDate.now(), 0F, 0F, 1000F, LocalDate.now(), cte1, TipoMoneda.DOLAR);
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("minibancoPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ClienteDAO clienteDao = new ClienteDAO(em);
		clienteDao.create(cte1);
		clienteDao.create(cte2);
		clienteDao.create(cte3);
		clienteDao.create(cte4);
		clienteDao.create(cte5);
		clienteDao.create(cte6);
		clienteDao.create(cte7);
		clienteDao.delete(cte2);
		cte3.setApellido("apellido update");
		
		System.out.println("RECUPERANDO LA LISTA DE CLIENTES X NOMBRE::::::::::::::");
		Collection<Cliente> collcli;
		collcli=clienteDao.getClientePorNombre("nombrecte3");
		for(Cliente c :collcli) {
		      System.out.println(c.getNombre() + " " + c.getApellido() + " " + c.getId());
		}

		CuentaDAO cuentaDao = new CuentaDAO(em);
		cuentaDao.create(ctaext1);
		cuentaDao.create(ctaext2);
		cuentaDao.create(ctaext3);
		cuentaDao.create(ctaext4);
		ctaext1.setSaldoInicial(654);
		ctaext1.setSaldoActual(789);
		
		System.out.println("RECUPERANDO LA LISTA DE CUENTAS X MONEDAE::::::::::::::");
		Collection<CuentaExtranjera> collcta;
		collcta=cuentaDao.getCuentaPorMoneda(TipoMoneda.DOLAR);
		for(CuentaExtranjera c :collcta) {
		      System.out.println(c.getMoneda()+"ENCONTRE ESTA MINEDA !!!!!");
		}

		
		
		tx.commit();
		
		em.close();
		emf.close();
			
		System.out.println("Fin Persistencia DAO...");
 
		
	}

}

