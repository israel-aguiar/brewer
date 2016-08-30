package com.algaworks.brewer.model;

public class Cidade {
	
	private Estado estado;
	private String nome;
	
	public Cidade() {
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
