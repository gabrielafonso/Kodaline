package com.afonjasam.Kodaline.model;
 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fotografo extends Usuario{
		
	@Column(name="detalhes")
	private String detalhes;
	
	@Column(name="sobre")
	private String sobre;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="redes_sociais_facebook")
	private String facebook_url;
	
	@Column(name="redes_sociais_twitter")
	private String twitter_url;
	
	@Column(name="redes_sociais_instagram")
	private String instagram_url;
	
	@OneToMany(
			mappedBy = "owner",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Album> album = new ArrayList<>();
	
	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFacebook_url() {
		return facebook_url;
	}

	public void setFacebook_url(String facebook_url) {
		this.facebook_url = facebook_url;
	}

	public String getTwitter_url() {
		return twitter_url;
	}

	public void setTwitter_url(String twitter_url) {
		this.twitter_url = twitter_url;
	}

	public String getInstagram_url() {
		return instagram_url;
	}

	public void setInstagram_url(String instagram_url) {
		this.instagram_url = instagram_url;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fotografo other = (Fotografo) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;

		return true;
	}


	public List<Album> getAlbum() {
		return album;
	}


	public void setAlbum(List<Album> albuns) {
		this.album = albuns;
	}
	
}
