package org.cursobbva.modulo4.proyecto.minibanco.controller;

import java.util.List;

import org.cursobbva.modulo4.proyecto.minibanco.dto.ClienteModifDireccionDTO;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.servicio.Servicio;
import org.cursobbva.modulo4.proyecto.minibanco.servicio.ServicioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ServicioCliente servicioCliente;

	@GetMapping("/")
	public List<Cliente> listar() {
		return servicioCliente.listarClientes();
	}

	@GetMapping("/buscarPorNombre/{nombre}")
	public List<Cliente> buscarPorNombre(@PathVariable String nombre) {
		return servicioCliente.listarClientesNombre(nombre);
	}

	@GetMapping("/buscarPorId/{idCliente}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long idCliente) {
		return new ResponseEntity<Cliente>(servicioCliente.leerClienteById(idCliente), HttpStatus.FOUND);
	}

	@PutMapping("/modificarDireccion")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void modificarDireccion(@RequestBody ClienteModifDireccionDTO clienteModifDireccionDTO) {
		servicioCliente.cambiarDireccionCliente(clienteModifDireccionDTO.getIdCliente(), clienteModifDireccionDTO.getNuevaDirecc());
	}

}
