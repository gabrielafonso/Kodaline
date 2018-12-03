package com.afonjasam.Kodaline.servicos;

public class TelefoneServico {

	public boolean validarTelefone(String telefone) {
		
		System.out.println(telefone.length());
		
		if(telefone.length() == 11) {
			for(int i = 0; i < telefone.length(); i++) {
 				if(!(Character.isDigit(telefone.charAt(i)))) {
					return false;
				}
			}
			return true;
		}
		
		return false;
	}
}
