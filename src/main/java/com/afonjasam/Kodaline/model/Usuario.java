package com.afonjasam.Kodaline.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Usuario {

	@Id	
	@GeneratedValue
	private Long id;
	
	@Column(name = "email", nullable=false, unique=true)
	private String email;
	@Column(name = "password", nullable=false, unique=true)
	private String password;
	
	@OneToMany(
			mappedBy = "owner",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Telefone> phones = new ArrayList<>();
}
