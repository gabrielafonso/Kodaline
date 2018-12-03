package com.afonjasam.Kodaline.servicos;

public class AlbumServico {

	public boolean validarAlbum(String titulo, int quantidade) {
		
		if(titulo.length() > 3) {
			for(int i = 0; i < titulo.length() ;i++) {
				if(!Character.isAlphabetic(titulo.charAt(i))) {
					return false;
				}
				if(i>0) {
					if(!(titulo.charAt(i) >= 97 && titulo.charAt(i) <= 122)) {
						return false;
					}
				}
			}
			
			if((titulo.charAt(0) >= 65 && titulo.charAt(0) <= 90) && quantidade >= 0) {
				return true;	
			}
		}
		
		return false;
	}
	
}
