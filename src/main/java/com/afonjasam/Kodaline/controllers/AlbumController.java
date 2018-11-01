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
import com.afonjasam.Kodaline.repository.AlbumRepository;
import com.afonjasam.Kodaline.repository.FotosRepository;

@RestController
public class AlbumController {
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@GetMapping("/album")
	public Page<Album> getAlbum(Pageable pageable){
		return albumRepository.findAll(pageable);	
	}
	
	@PostMapping("/album")
	public Album creatFotos(@Valid @RequestBody Album album) {
		return albumRepository.save(album);	
	}
	
	@PutMapping("/album/{albumId}")
	public Album updateAlbum (@PathVariable Long albumId,
			@Valid @RequestBody Album albumRequest) {
            	return albumRepository.findById(albumId)
				.map(album -> {
					album.setTitulo(albumRequest.getTitulo());
					album.setQntfotos(albumRequest.getQntfotos());
					return albumRepository.save(album);
		}).orElseThrow(() -> new ResourceNotFoundException("Album not found: " + albumId));
	}
	
	@DeleteMapping("/album/{albumId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long albumId){
		return albumRepository.findById(albumId)
				.map(album -> {
					albumRepository.delete(album);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Album not found: " + albumId));
	}

}
