package com.afonjasam.Kodaline;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.afonjasam.Kodaline.servicos.TelefoneServico;

public class TelefoneTesteValidacao {

	TelefoneServico ts;
	
	@Before
	public void setUp() throws Exception {
		ts = new TelefoneServico();
	}

	@Test
	public void testValidarTelefoneCorreto() {
		assertEquals(true, ts.validarTelefone("82123456789"));
	}
	
	@Test
	public void testValidarTelefoneLetraNoMeio() {
		assertEquals(false, ts.validarTelefone("82a2345678"));
	}

	@Test
	public void testValidarTelefoneEmBranco() {
		assertEquals(false, ts.validarTelefone(""));
	}

	@Test
	public void testValidarTelefoneComEspaco() {
		assertEquals(false, ts.validarTelefone("82 1234 5678"));
	}

	@Test
	public void testValidarTelefoneComCaracteres() {
		assertEquals(false, ts.validarTelefone("82.1234-5678"));
	}

	
}
