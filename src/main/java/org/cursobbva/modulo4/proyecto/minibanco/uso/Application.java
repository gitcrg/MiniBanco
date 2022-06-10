package org.cursobbva.modulo4.proyecto.minibanco.uso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude = TransactionAutoConfiguration.class, scanBasePackages = "org.cursobbva.modulo4.proyecto.minibanco.controller,org.cursobbva.proyecto.modulo4.minibanco.servicio")
@ImportResource("spring/contexto-jpa-test.xml")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
