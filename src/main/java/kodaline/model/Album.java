package kodaline.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Album {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String titulo;
	@Column
	private String qntfotos;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Long getIdAlbum() {
		return idAlbum;
	}
	public void setIdAlbum(Long idAlbum) {
		this.idAlbum = idAlbum;
	}
	
	
	public Album() {
		super();
	}
	

	
}
