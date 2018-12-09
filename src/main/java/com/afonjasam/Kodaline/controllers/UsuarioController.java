package com.afonjasam.Kodaline.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.afonjasam.Kodaline.exception.ResourceNotFoundException;
import com.afonjasam.Kodaline.model.Telefone;
import com.afonjasam.Kodaline.model.Usuario;
import com.afonjasam.Kodaline.repository.UsuarioRepository;

@Repository
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuario")
	public Page<Usuario>getUsuarios(Pageable pageable){
		return usuarioRepository.findAll(pageable);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public Usuario getUsuario(@PathVariable Long usuarioId) {
		return usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario not found: " + usuarioId));
	}
	
	@PostMapping("/usuario")
	public Usuario createUsuario(@Valid @RequestBody Usuario usuario){
		return usuarioRepository.save(usuario);
	}
	
	@PutMapping("/usuario/{usuarioId}")
	public Usuario updateUsuario (@PathVariable Long usuarioId, 
			                          @Valid @RequestBody Usuario usuarioRequest) {
		return usuarioRepository.findById(usuarioId)
				.map(usuario -> {
					usuario.setEmail(usuarioRequest.getEmail());
					usuario.setNome(usuarioRequest.getNome());
					usuario.setPassword(usuarioRequest.getPassword());
					usuario.setTelefones(usuarioRequest.getTelefones());
					return usuarioRepository.save(usuario);
		}).orElseThrow(()-> new ResourceNotFoundException("Usuario not found: " + usuarioId));
	}
	
	@PostMapping("usuario/{usuarioId}/addtelefone")
	public Usuario addPhone(@PathVariable Long usuarioId,
									@Valid @RequestBody Telefone telefone) {
		return usuarioRepository.findById(usuarioId)
				.map(usuario -> {
					usuario.addTelefone(telefone);
					telefone.setOwner(usuario);
					return usuarioRepository.save(usuario);
				}).orElseThrow(() -> new ResourceNotFoundException("Usuario not found: " + usuarioId));
	}
	
	@DeleteMapping("/usuario/{usuarioId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long usuarioId){
		return usuarioRepository.findById(usuarioId)
				.map(usuario -> {
					usuarioRepository.delete(usuario);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Usuario not found: " + usuarioId));
	}

}
