package com.afonjasam.Kodaline;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.afonjasam.Kodaline.servicos.FotosServico;

public class FotoTesteValidacao {

FotosServico fs;
	
	@Before
	public void setUp() throws Exception {
		fs = new FotosServico();
	}

	@Test
	public void testValidarFotoCorreto() {
		assertEquals(true, fs.validarFoto("Fotos da aula inaugural."));
	}

	@Test
	public void testValidarFotoCorretoEmBranco() {
		assertEquals(false, fs.validarFoto(""));
	}
}
