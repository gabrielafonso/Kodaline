package com.afonjasam.Kodaline.servicos;

import java.time.LocalDate;

public class FotosServico {

	public boolean validarFoto(String detalhes) {
		
		if(detalhes.length() > 10) {
			return true;
		}
		
		return false;
	}
	
}
