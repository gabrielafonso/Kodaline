package Testes;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlbumTeste {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void TituloComNumeros() {
		String titulo = "C45ament0";
		String qntfotos = "180";
	}
	
	@Test
	public void TituloComCaracter() {
		String titulo = "C@samen*to";
		String qntfotos = "180";
	}
	
	@Test
	public void TituloSemEspaco() {
		String titulo = "CasamentoVirginiaeLeandro";
		String qntfotos = "180";
	}
	
	
}
