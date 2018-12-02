package com.afonjasam.Kodaline;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.afonjasam.Kodaline.servicos.UsuarioServico;

public class UsuarioTesteValidacao {

	UsuarioServico sv;
	
	@Before
	public void setUp() throws Exception {
		sv = new UsuarioServico();
	}

	@Test
	public void testValidarUsuarioCorreto() {
		assertEquals(true, sv.validarUsuario("asdf@sdfg.com", "12345678"));
	}

	@Test
	public void testValidarUsuarioSemArroba() {
		assertEquals(true, sv.validarUsuario("asdsdfg.com", "!@#$%¨&*"));
	}
	
	@Test
	public void testValidarUsuarioSemPonto() {
		assertEquals(true, sv.validarUsuario("asdf@sdfgcom", "asdfqwer"));
	}
	
	@Test
	public void testValidarUsuarioVazio() {
		assertEquals(true, sv.validarUsuario("", ""));
	}
	
	@Test
	public void testValidarUsuarioEspaco() {
		assertEquals(true, sv.validarUsuario(" ", " "));
	}
	
	@Test
	public void testValidarUsuarioIformacoesInvertidas() {
		assertEquals(true, sv.validarUsuario("asdf.asd@adf", "12345678"));
	}
	
}
