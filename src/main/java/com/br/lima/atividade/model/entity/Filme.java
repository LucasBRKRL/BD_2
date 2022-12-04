package com.br.lima.atividade.model.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_filme")
public class Filme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cd_filme;
	private String titulo;
	private String ano;
	private String genero;
	private Integer faixaEtaria;

	@OneToMany(mappedBy = "filme")
	@JsonIgnore
	Set<Exibicao> exibicoes;

	public Filme() {

	}

	public Filme(Long cd_filme, String titulo, String ano, String genero, Integer faixaEtaria,
			Set<Exibicao> exibicoes) {
		super();
		this.cd_filme = cd_filme;
		this.titulo = titulo;
		this.ano = ano;
		this.genero = genero;
		this.faixaEtaria = faixaEtaria;
		this.exibicoes = exibicoes;
	}

	public Long getCd_filme() {
		return cd_filme;
	}

	public void setCd_filme(Long cd_filme) {
		this.cd_filme = cd_filme;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(Integer faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public Set<Exibicao> getExibicoes() {
		return exibicoes;
	}

	public void setExibicoes(Set<Exibicao> exibicoes) {
		this.exibicoes = exibicoes;
	}

}
