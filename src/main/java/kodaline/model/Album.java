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
	@Column(name = "Titulo_Album",nullable=false)
	private String titulo;
	@Column(name = "Quantidade_Fotos",nullable=false)
	private String qntfotos;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getQntfotos() {
		return qntfotos;
	}

	public void setQntfotos(String qntfotos) {
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
		result = prime * result + ((qntfotos == null) ? 0 : qntfotos.hashCode());
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
		if (qntfotos == null) {
			if (other.qntfotos != null)
				return false;
		} else if (!qntfotos.equals(other.qntfotos))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
	

	
}
