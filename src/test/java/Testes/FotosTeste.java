package Testes;

import static org.junit.Assert.*;

import org.junit.Test;

public class FotosTeste {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void DetalhesComNumeros() {
		String detalhes = "1234567890";
		String Date = "12/12/2010";
		String album = "Almoco em Familia";
	}
	
	@Test
	public void DetalhesSemEspaco() {
		String detalhes = "SomenteOsFamiliares";
		String Date = "12/12/2010";
		String album = "Almoco em Familia";
	}
	
	@Test
	public void DateSemBarras() {
		String detalhes = "Somente Familiares";
		String Date = "12122010";
		String album = "Almoco em Familia";
	}
	
	@Test
	public void DateComLetras() {
		String detalhes = "Somente Familiares";
		String Date = "Dose de Dezembro de dois mil e dez";
		String album = "Almoco em Familia";
	}
	
	@Test
	public void AlbumComNumeros() {
		String detalhes = "Somente Familiares";
		String Date = "12/12/2012";
		String album = "4almoc0 3m f4am1l14";
	}
	
	@Test
	public void AlbumSemEspaco() {
		String detalhes = "Somente Familiares";
		String Date = "12/12/2010";
		String album = "AlmocoEmFamilia";
	}
}
