package com.afonjasam.Kodaline.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Album {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "titulo_album",nullable=false)
	private String titulo;
	@Column(name = "quantidade_fotos",nullable=false)
	private int qntfotos;
	
	@OneToMany(
			mappedBy="album",
			cascade=CascadeType.ALL,
			orphanRemoval=true
			)
	@JsonBackReference
	private List<Fotos> fotos = new ArrayList<>();
	
	@ManyToOne
	private Fotografo owner;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Fotos> getFotos() {
		return fotos;
	}

	public void setFotos(List<Fotos> fotos) {
		this.fotos = fotos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getQntfotos() {
		return qntfotos;
	}

	public void setQntfotos(int qntfotos) {
		this.qntfotos = qntfotos;
	}


	public Album() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
	

	
}
