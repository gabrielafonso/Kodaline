package com.afonjasam.Kodaline;


import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.afonjasam.Kodaline.servicos.FotografoServico;

public class FotografoTesteValidacao {

	FotografoServico ft;
	
	@Before
	public void setUp() throws Exception {
		ft = new FotografoServico();
	}

	@Test
	public void testValidarFotografoCorreto() {
		Assert.assertEquals(true, ft.validarFotografo("João", "Silva"));
	}
	
	@Test
	public void testValidarFotografoMinusculo() {
		Assert.assertEquals(false, ft.validarFotografo("joão", "silva"));
	}
	
	@Test
	public void testValidarFotografoEmBranco() {
		Assert.assertEquals(false, ft.validarFotografo("", ""));
	}
	
	@Test
	public void testValidarFotografoComEspaco() {
		Assert.assertEquals(false, ft.validarFotografo(" ", " "));
	}

}
