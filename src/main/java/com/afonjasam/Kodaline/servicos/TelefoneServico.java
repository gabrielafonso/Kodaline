package com.afonjasam.Kodaline.servicos;

public class TelefoneServico {

	public boolean validarTelefone(String telefone) {
		
		if(telefone.length() == 11) {
			for(int i = 0; i < telefone.length() ;i++) {
				if(Character.isDigit(telefone.charAt(i))) {
					return true;
				}else return false;
			}
		}
		
		return false;
	}
}
