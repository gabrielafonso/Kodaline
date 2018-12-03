package com.afonjasam.Kodaline;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.afonjasam.Kodaline.servicos.ClienteServico;

public class ClienteTesteValidacao {

	ClienteServico cs;
	
	@Before
	public void setUp() throws Exception {
		cs = new ClienteServico();
	}

	@Test
	public void testValidarFotografoCorreto() {
		Assert.assertEquals(true, cs.validarCliente("João", "Silva"));
	}
	
	@Test
	public void testValidarFotografoMinusculo() {
		Assert.assertEquals(false, cs.validarCliente("joão", "silva"));
	}
	
	@Test
	public void testValidarFotografoEmBranco() {
		Assert.assertEquals(false, cs.validarCliente("", ""));
	}
	
	@Test
	public void testValidarFotografoComEspaco() {
		Assert.assertEquals(false, cs.validarCliente(" ", " "));
	}

}
