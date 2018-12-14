package com.afonjasam.Kodaline.controllers;

import java.util.Map;

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
import com.afonjasam.Kodaline.model.Fotografo;
import com.afonjasam.Kodaline.model.Telefone;
import com.afonjasam.Kodaline.repository.FotografoRepository;

@RestController
public class FotografoController {

	@Autowired
	private FotografoRepository fotografoRepository;
	
	@GetMapping("/fotografo")
	public Page<Fotografo>getFotografos(Pageable pageable){
		return fotografoRepository.findAll(pageable);
	}
	
	@GetMapping("/fotografo/{fotografoId}")
	public Fotografo getAlbum(@PathVariable Long fotografoId){
		return fotografoRepository.findById(fotografoId)
				.orElseThrow(() -> new ResourceNotFoundException("Album not found: " + fotografoId));

	}
	
	@PostMapping("/fotografo")
	public Fotografo createFotografo(@Valid @RequestBody Fotografo fotografo){
		return fotografoRepository.save(fotografo);
	}
	
	@PostMapping("/login")
	public Fotografo loginFotografo(@RequestBody Map<String, String> params){
		return fotografoRepository.findByEmailAndPassword(params.get("email"), params.get("password"));
	}
	

	
	@PutMapping("/fotografo/{fotografoId}")
	public Fotografo updateFotografo (@PathVariable Long fotografoId, 
			                          @Valid @RequestBody Fotografo fotografoRequest) {
		return fotografoRepository.findById(fotografoId)
				.map(fotografo -> {
					fotografo.setAlbum(fotografoRequest.getAlbum());
					fotografo.setEmail(fotografoRequest.getEmail());
					fotografo.setNome(fotografoRequest.getNome());
					fotografo.setPassword(fotografoRequest.getPassword());
					fotografo.setTelefones(fotografoRequest.getTelefones());
					fotografo.setDetalhes(fotografoRequest.getDetalhes());
					fotografo.setEndereco(fotografoRequest.getEndereco());
					fotografo.setSobre(fotografoRequest.getSobre());
					fotografo.setFacebook_url(fotografoRequest.getFacebook_url());
					fotografo.setInstagram_url(fotografoRequest.getInstagram_url());
					fotografo.setTwitter_url(fotografoRequest.getTwitter_url());
					return fotografoRepository.save(fotografo);
		}).orElseThrow(()-> new ResourceNotFoundException("Fotografo not found: " + fotografoId));
	}
	
	@PostMapping("fotografo/{fotografoId}/addtelefone")
	public Fotografo addPhone(@PathVariable Long fotografoId,
									@Valid @RequestBody Telefone telefone) {
		return fotografoRepository.findById(fotografoId)
				.map(fotografo -> {
					fotografo.addTelefone(telefone);
					telefone.setOwner(fotografo);
					return fotografoRepository.save(fotografo);
				}).orElseThrow(() -> new ResourceNotFoundException("FamilyMember not found: " + fotografoId));
	}
	
	@DeleteMapping("/fotografo/{fotografoId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long fotografoId){
		return fotografoRepository.findById(fotografoId)
				.map(fotografo -> {
					fotografoRepository.delete(fotografo);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Fotografo not found: " + fotografoId));
	}
	
}
