package kodaline.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Cliente {

	@Id	
	@GeneratedValue
	private Long id;
	@Column
	private String dadosBancarios;
	@Column
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
	
	

}
