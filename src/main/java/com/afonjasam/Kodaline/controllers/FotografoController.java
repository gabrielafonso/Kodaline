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
import com.afonjasam.Kodaline.repository.FotografoRepository;
import com.afonjasam.Kodaline.model.Fotografo;

@RestController
public class FotografoController {

	@Autowired
	private FotografoRepository fotograforepository;
	
	@GetMapping("/fotografo")
	public Page<Fotografo>getFotografos(Pageable pageable){
		return fotograforepository.findAll(pageable);
	}
	
	@PostMapping("/fotografo")
	public Fotografo createFotografo(@Valid @RequestBody Fotografo fotografo){
		return fotograforepository.save(fotografo);
}
	@PutMapping("/fotografo /{fotografoId}")
	public Fotografo updateFotografo (@PathVariable Long fotografoId, 
			                          @Valid @RequestBody Fotografo fotografoRequest) {
		return fotograforepository.findById(fotografoId)
				.map(fotografo->{
					fotografo.setAlbum(fotografoRequest.getAlbum());
					fotografo.setFotos(fotografoRequest.getFotos());
		            return fotograforepository.save(fotografo);
		}).orElseThrow(()-> new ResourceNotFoundException("Fotografo not found: " +fotografoId));
	}
	
	@DeleteMapping("/fotografo/{fotografoId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long fotografoId){
		return fotograforepository.findById(fotografoId)
				.map(fotografo -> {
					fotograforepository.delete(fotografo);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Fotografo not found: " + fotografoId));
	}
	
}
