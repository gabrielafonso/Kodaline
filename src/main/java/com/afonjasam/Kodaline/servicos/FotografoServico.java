package com.afonjasam.Kodaline.servicos;

public class FotografoServico {

	public boolean validarFotografo(String nome, String sobrenome) {

		if(nome.length() > 3 && sobrenome.length() > 3) {	
			for(int i = 0; i < nome.length() ;i++) {
				if(!Character.isAlphabetic(nome.charAt(i))) {
					return false;
				}
				if(i>0) {
					if(!(nome.charAt(i) >= 97 && nome.charAt(i) <= 122)) {
						
					}
				}
			}
			for(int i = 0; i < sobrenome.length() ;i++) {
				if(!Character.isAlphabetic(sobrenome.charAt(i))) {
					return false;
				}
				if(i>0) {
					if(!(sobrenome.charAt(i) >= 97 && sobrenome.charAt(i) <= 122)) {
						
					}
				}
			}
			
			if((nome.charAt(0) >= 65 && nome.charAt(0) <= 90) &&
					((sobrenome.charAt(0) >= 65 && sobrenome.charAt(0) <= 90))) {
				return true;	
			}
		}
		return false;
	}
}
