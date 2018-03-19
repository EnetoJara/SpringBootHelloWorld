package com.netoscompany.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.netoscompany.apirest.models.entity.Cliente;
import com.netoscompany.apirest.models.services.ClienteService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private ClienteService service;
	
	@GetMapping("/clientes")
	public List<Cliente> index() {
		return this.service.findAll();
	}
	
	@GetMapping("/cliente/{id}")
	public Cliente show (@PathVariable Long id) {
		return this.service.findById(id);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create (@RequestBody Cliente cliente) {
		return this.service.save(cliente);
	}
	
	@PutMapping("/clientes/{id}")
	public Cliente update (@RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente actual = this.service.findById(id);
		actual.setApellido(cliente.getApellido());
		actual.setNombre(cliente.getNombre());
		actual.setEmal(cliente.getEmal());
		return this.service.save(actual);
	}
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id) {
		this.service.delete(id);
	}
}
