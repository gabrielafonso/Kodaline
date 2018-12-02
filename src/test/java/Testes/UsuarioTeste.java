package Testes;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioTeste {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void EmailSemArroba() {
		String email = "afonsogabrieljustinogmail.com";
		String password = "123456";
		
	}
	
	@Test
	public void EmailSemPonto() {
		String email = "afonsogabrieljustino@gmailcom";
		String password = "123456";
		
	}
	
	@Test
	public void EmailSomenteComNumeros() {
		String email = "123456789@gmail.com";
		String password = "123456";
		
	}
	
	@Test
	public void EmailSemGmail() {
		String email = "afonsogabrieljustino@com";
		String password = "123456";
		
	}
	
	@Test
	public void EmailSemPontoCom() {
		String email = "afonsogabrieljustino@gmail.br";
		String password = "123456";
		
	}
	
	@Test
	public void EmailSemHotmail() {
		String email = "afonsogabrieljustino@live.com";
		String password = "123456";
		
	}
	
	@Test
	public void PasswordComMenosDeSeisDigitos() {
		String email = "afonsogabrieljustino@gmail.com";
		String password = "12345";
		
	}
}
