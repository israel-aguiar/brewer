package com.algaworks.brewer.model;

import org.hibernate.validator.constraints.NotBlank;

public class Grupo {

	@NotBlank
	private String nome;

	public Grupo() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
