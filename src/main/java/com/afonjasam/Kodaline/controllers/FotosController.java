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
import com.afonjasam.Kodaline.model.Album;
import com.afonjasam.Kodaline.model.Fotos;
import com.afonjasam.Kodaline.repository.FotosRepository;


@RestController
public class FotosController {
	
	@Autowired
	private FotosRepository fotosRepository;
	
	@GetMapping("/fotos")
	public Page<Fotos> getFoto(Pageable pageable){
		return fotosRepository.findAll(pageable);	
	}
	
	@GetMapping("/fotos/{fotosId}")
	public Fotos getAlbum(@PathVariable Long fotosId){
		return fotosRepository.findById(fotosId)
				.orElseThrow(() -> new ResourceNotFoundException("Album not found: " + fotosId));

	}
	
	@PostMapping("/fotos")
	public Fotos creatFotos(@Valid @RequestBody Fotos fotos) {
		return fotosRepository.save(fotos);	
	}
	
	@PutMapping("/fotos/{fotosId}")
	public Fotos updateFotos (@PathVariable Long fotosId,
			@Valid @RequestBody Fotos fotosRequest) {
            	return fotosRepository.findById(fotosId)
				.map(fotos -> {
					fotos.setDate(fotosRequest.getDate());
					fotos.setDetalhes(fotosRequest.getDetalhes());
					return fotosRepository.save(fotos);
		}).orElseThrow(() -> new ResourceNotFoundException("Fotos not found: " + fotosId));
	}
	
	@DeleteMapping("/fotos/{fotosId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long fotosId){
		return fotosRepository.findById(fotosId)
				.map(fotos -> {
					fotosRepository.delete(fotos);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Fotos not found: " + fotosId));
	}

}
