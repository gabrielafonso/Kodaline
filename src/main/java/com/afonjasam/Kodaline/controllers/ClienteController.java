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
import com.afonjasam.Kodaline.model.Telefone;
import com.afonjasam.Kodaline.repository.ClienteRepository;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/cliente")
	public Page<Cliente> getCliente(Pageable pageable){
		return clienteRepository.findAll(pageable);	
	}
	
	@GetMapping("/cliente/{clienteId}")
	public Cliente getAlbum(@PathVariable Long clienteId){
		return clienteRepository.findById(clienteId)
				.orElseThrow(() -> new ResourceNotFoundException("Album not found: " + clienteId));

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
					cliente.setEmail(clienteRequest.getEmail());
					cliente.setNome(clienteRequest.getNome());
					cliente.setTelefones(clienteRequest.getTelefones());
					return clienteRepository.save(cliente);
		}).orElseThrow(() -> new ResourceNotFoundException("Cliente not found: " + clienteId));
	}
	
	@PostMapping("cliente/{clienteId}/addtelefone")
	public Cliente addPhone(@PathVariable Long clienteId,
									@Valid @RequestBody Telefone telefone) {
		return clienteRepository.findById(clienteId)
				.map(cliente -> {
					cliente.addTelefone(telefone);
					telefone.setOwner(cliente);
					return clienteRepository.save(cliente);
				}).orElseThrow(() -> new ResourceNotFoundException("FamilyMember not found: " + clienteId));
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
