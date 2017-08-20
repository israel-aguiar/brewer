package com.algaworks.brewer.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Embeddable
public class Endereco implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String logradouro;
	
	public String numero;
	
	public String complemento;
	
	public String cep;
	
	@ManyToOne
	@JoinColumn(name = "codigo_cidade")
	public Cidade cidade;
	
	@Transient
	public Estado estado;

	public Endereco() {
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public String getNomeCidadeSiglaEstado() {
		if (this.cidade != null)
			return this.cidade.getNome() + "/" + this.cidade.getEstado().getSigla();
		
		return null;
	}
}