package com.afonjasam.Kodaline.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Cliente extends Pessoa {

	@Id	
	@GeneratedValue
	private Long id;
	@Column(name = "dados_bancarios",nullable=false)
	private String dadosBancarios;
	@Column(name = "pedidos",nullable=false)
	private String pedidos;
	
	public String getDadosBancarios() {
		return dadosBancarios;
	}
	public void setDadosBancarios(String dadosBancarios) {
		this.dadosBancarios = dadosBancarios;
	}
	public String getPedidos() {
		return pedidos;
	}
	public void setPedidos(String pedidos) {
		this.pedidos = pedidos;
	}
	
	
	public Cliente() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dadosBancarios == null) ? 0 : dadosBancarios.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pedidos == null) ? 0 : pedidos.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (dadosBancarios == null) {
			if (other.dadosBancarios != null)
				return false;
		} else if (!dadosBancarios.equals(other.dadosBancarios))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pedidos == null) {
			if (other.pedidos != null)
				return false;
		} else if (!pedidos.equals(other.pedidos))
			return false;
		return true;
	}
	
	
	
	

}
