package Testes;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClienteTeste {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void NomesComLetras() {
		String nome = "4fon50";
		String dadosBancarios = "296689";
	}
	
	@Test
	public void NomesNumeros() {
		String nome = "1234567890";
		String dadosBancarios = "296680";
	}
	
	@Test
	public void NomesComCaracter() {
		String nome = "@fons*/+";
		String dadosBancarios = "296689";
	}
	
	@Test
	public void NomesCaracter() {
		String nome = "@fons*/+";
		String dadosBancarios = "296689";
	}
	
	
	@Test
	public void NomessemEspaco() {
		String nome = "AfonsoGabriel";
		String dadosBancarios = "296689";
	}
	
	@Test
	public void dadosBancariosComLetras() {
		String nome = "Afonso";
		String dadosBancarios = "Afonso";
	}
	
	@Test
	public void dadosBancariosComCaracter() {
		String nome = "Afonso";
		String dadosBancarios = "/*-@";
	}
}
