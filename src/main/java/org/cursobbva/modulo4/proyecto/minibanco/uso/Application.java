package org.cursobbva.modulo4.proyecto.minibanco.uso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude = TransactionAutoConfiguration.class, scanBasePackages = "org.cursobbva.modulo4.minibanco.controller,org.cursobbva.modulo4.minibanco.servicios")
@ImportResource("spring/contexto-jpa.xml")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
