package kodaline.model;
 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Fotografo {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String album;
	@Column(nullable=false)
	private String fotos;
	
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getFotos() {
		return fotos;
	}
	public void setFotos(String fotos) {
		this.fotos = fotos;
	}
	
	
	public Fotografo() {
		super();
	}

	
	
}
