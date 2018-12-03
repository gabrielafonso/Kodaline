package com.afonjasam.Kodaline;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.afonjasam.Kodaline.servicos.AlbumServico;

public class AlbumTesteValidacao {

	AlbumServico as;
	
	@Before
	public void setUp() throws Exception {
		as = new AlbumServico();
	}

	@Test
	public void testValidarAlbumCorreto() {
		assertEquals(true, as.validarAlbum("Ifal - fotos", 10));
	}

}
