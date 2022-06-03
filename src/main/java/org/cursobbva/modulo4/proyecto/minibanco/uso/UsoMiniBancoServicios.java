package org.cursobbva.modulo4.proyecto.minibanco.uso;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;
import org.cursobbva.modulo4.proyecto.minibanco.servicios.Servicio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UsoMiniBancoServicios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/contexto-jpa.xml");
		Servicio servicio = ctx.getBean("servicio", Servicio.class);
		
		Direccion dir1 = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
		Direccion dir2 = new Direccion("calle2", "numero2", "departamento2", "piso2", "ciudad2", "codigoPostal2", "provincia2");
		Direccion dir3 = new Direccion("calle3", "numero3", "departamento3", "piso3", "ciudad3", "codigoPostal3", "provincia3");
		
		
		try {
			servicio.altaCliente("nombrecte1", "apellido1", "tel1", "email", dir1);
			servicio.altaCliente("nombrecte2", "apellido2", "tel2", "email", dir2);
			servicio.altaCliente("nombrecte3", "apellido3", "tel3", "email", dir3);
			servicio.altaCliente("nombrecte3", "apellido4", "tel4", "email", dir3);
			servicio.altaCliente("nombrecte2", "apellido5", "tel5", "email", dir3);
			servicio.altaCliente("nombrecte3", "apellido6", "tel6", "email", dir3);
			servicio.altaCliente("nombrecte3", "apellido7", "tel7", "email", dir1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			servicio.altaCuenta(1000F, 10000, 1L, TipoMoneda.USD);
			servicio.altaCuenta(2000F, 10000, 2L, TipoMoneda.USD);
			servicio.altaCuenta(3000F, 12220, 3L, TipoMoneda.USD);
			servicio.altaCuenta(4000F, 511550, 1L, TipoMoneda.EUR);
			servicio.altaCuenta(5000F, 1510, 2L, TipoMoneda.EUR);
			servicio.altaCuenta(1000F, 115260, 3L, TipoMoneda.EUR);
			servicio.altaCuenta(2000F, 112250, 1L, null);
			servicio.altaCuenta(3000F, 112150, 2L, null);
			servicio.altaCuenta(4000F, 11520, 3L, null);
			servicio.altaCuenta(5000F, 225000, 4L, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			servicio.agregarCotitular(1L, 2L);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			servicio.agregarCotitular(1L, 2L);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			servicio.agregarCotitular(2L, 10L);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			servicio.transferir(1L, 2L, 10F);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		try {
			servicio.vender(1L, 1L, 7L, 15F);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		((ConfigurableApplicationContext) ctx).close();
	}
}
