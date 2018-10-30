package com.afonjasam.Kodaline.controllers;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afonjasam.Kodaline.model.Fotos;
import com.afonjasam.Kodaline.repository.FotosRepository;

@RestController
public class FotosController {
	
	@Autowired
	private FotosRepository fotosrepository;
	
	@GetMapping("/fotos")
	public Page<Fotos> getFoto(Pageable pageable){
		return fotosrepository.findAll(pageable);
		
	}
	

}
