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
		assertEquals(true, ts.validarTelefone("8212345678"));
	}

}
