package com.afonjasam.Kodaline.servicos;

public class AlbumServico {

	public boolean validarAlbum(String titulo, int quantidade) {
		
		if(titulo.length() > 3) {
			if(quantidade >= 0) {
				return true;	
			}
		}
		return false;
	}
	
}
