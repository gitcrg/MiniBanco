package org.cursobbva.modulo4.proyecto.minibanco.main;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;
import org.cursobbva.modulo4.proyecto.minibanco.servicio.ServicioCliente;
import org.cursobbva.modulo4.proyecto.minibanco.servicio.ServicioCuenta;
import org.cursobbva.modulo4.proyecto.minibanco.servicio.ServicioMovimiento;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Main para uso de Servicios
 * @author Cristian Gutierrez
 *
 */
public class UsoMiniBancoServicios {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/contexto-jpa.xml");
		ServicioCliente servicioCliente = ctx.getBean("servicioCliente", ServicioCliente.class);
		ServicioCuenta servicioCuenta = ctx.getBean("servicioCuenta", ServicioCuenta.class);
		ServicioMovimiento servicioMovimiento = ctx.getBean("servicioMovimiento", ServicioMovimiento.class);
		
		Direccion dir1 = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
		Direccion dir2 = new Direccion("calle2", "numero2", "departamento2", "piso2", "ciudad2", "codigoPostal2", "provincia2");
		Direccion dir3 = new Direccion("calle3", "numero3", "departamento3", "piso3", "ciudad3", "codigoPostal3", "provincia3");
		
		
		try {
			servicioCliente.altaCliente("nombrecte1", "apellido1", "tel1", "email1@email.com", dir1);
			servicioCliente.altaCliente("nombrecte2", "apellido2", "tel2", "email2@email.com", dir2);
			servicioCliente.altaCliente("nombrecte3", "apellido3", "tel3", "email3@email.com", dir3);
			servicioCliente.altaCliente("nombrecte3", "apellido4", "tel4", "email4@email.com", dir3);
			servicioCliente.altaCliente("nombrecte2", "apellido5", "tel5", "email5@email.com", dir3);
			servicioCliente.altaCliente("nombrecte3", "apellido6", "tel6", "email6@email.com", dir3);
			servicioCliente.altaCliente("nombrecte3", "apellido7", "tel7", "email7@email.com", dir1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			servicioCuenta.altaCuenta(1000D, 10000D, 1L, TipoMoneda.USD);
			servicioCuenta.altaCuenta(2000D, 10000D, 2L, TipoMoneda.USD);
			servicioCuenta.altaCuenta(3000D, 12220D, 3L, TipoMoneda.USD);
			servicioCuenta.altaCuenta(4000D, 511550D, 1L, TipoMoneda.EUR);
			servicioCuenta.altaCuenta(5000D, 1510D, 2L, TipoMoneda.EUR);
			servicioCuenta.altaCuenta(1000D, 115260D, 3L, TipoMoneda.EUR);
			servicioCuenta.altaCuenta(2000D, 112250D, 1L, null);
			servicioCuenta.altaCuenta(3000D, 112150D, 2L, null);
			servicioCuenta.altaCuenta(4000D, 11520D, 3L, null);
			servicioCuenta.altaCuenta(5000D, 225000D, 4L, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			servicioCuenta.agregarCotitular(1L, 2L);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			servicioCuenta.agregarCotitular(4L, 3L);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			servicioCuenta.agregarCotitular(2L, 10L);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			servicioMovimiento.transferir(1L, 2L, 10D);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		try {
			servicioMovimiento.vender(1L, 1L, 7L, 25.0);
//			servicioMovimiento.vender(1L, 5L, 1L, 15.0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		((ConfigurableApplicationContext) ctx).close();
	}
}
