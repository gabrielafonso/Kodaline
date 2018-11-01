package com.afonjasam.Kodaline.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.afonjasam.Kodaline.exception.ResourceNotFoundException;
import com.afonjasam.Kodaline.model.Cliente;
import com.afonjasam.Kodaline.model.Fotos;
import com.afonjasam.Kodaline.repository.ClienteRepository;
import com.afonjasam.Kodaline.repository.FotosRepository;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/fotos")
	public Page<Cliente> getCliente(Pageable pageable){
		return clienteRepository.findAll(pageable);	
	}
	
	@PostMapping("/cliente")
	public Cliente creatClientes(@Valid @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);	
	}
	
	@PutMapping("/cliente/{clienteId}")
	public Cliente updateCliente (@PathVariable Long clienteId,
			@Valid @RequestBody Cliente clienteRequest) {
            	return clienteRepository.findById(clienteId)
				.map(cliente -> {
					cliente.setDadosBancarios(clienteRequest.getDadosBancarios());
					cliente.setPedidos(clienteRequest.getPedidos());
					return clienteRepository.save(cliente);
		}).orElseThrow(() -> new ResourceNotFoundException("Cliente not found: " + clienteId));
	}
	
	@DeleteMapping("/cliente/{clienteId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long clienteId){
		return clienteRepository.findById(clienteId)
				.map(cliente -> {
					clienteRepository.delete(cliente);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("cliente not found: " + clienteId));
	}

}
