package Testes;

import static org.junit.Assert.*;

import org.junit.Test;

public class FotografoTeste {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

//
@Test
public void NomeComLetrasMinusculasComEspaco() {
	String nome = "guilherme fonseca";
}

//
@Test
public void NomeComLetrasMinusculasSemEspaco() {
	String nome = "guilhermefonseca";
}

@Test
public void NomeSemEspaco() {
	String nome = "GuilhermeFonseca";
}

@Test
public void NomeComNumeros() {
	String nome = "guilh30rm3 f7892602onsec4";
}

//
@Test
public void NomeComCaracter() {
	String nome = "gu/lh*@fons*+ ";
	
}

}
