package com.afonjasam.Kodaline.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.afonjasam.Kodaline.orElseThrowmodel.Fotografo;
import com.afonjasam.Kodaline.repository.FotografoRepository;

@RestController
public class FotografoController {

	@Autowired
	private FotografoRepository fotograforepository;
	
	@GetMapping("/fotografo")
	public Page<Fotografo>getFotografo(Pageable pageable){
		return fotograforepository.findAll(pageable);
	}
	
	@PostMapping("/fotografo")
	public Fotografo createFotografo(@Valid @RequestBody Fotografo fotografo){
		return fotograforepository.save(fotografo);
}
	@PostMapping("/fotografo /{fotografoId}")
	public Fotografo updateFotografo (@PathVariable Long fotografoId, @Valid @RequestBody Fotografo fotografoRequest) {
		return fotograforepository.findById(fotografoId).map(fotografo->{fotografo.setAlbum(fotografoRequest.getFotos());
		return fotograforepository.save(fotografo);
		}).orElseThrow(()-> new ResourceNotFoundException("Fotografo não encontrado:"+fotografoId));
	}
	
	@DeleteMapping()
}
