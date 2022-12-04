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
@Table(name = "tb_cinema")
public class Cinema {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cd_cinema;
	private String nm_cinema;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String lotacao;
	
	@OneToMany(mappedBy = "cinema")
	@JsonIgnore
	Set<Exibicao> exibicoes;

	public Cinema() {
		super();
	}

	public Cinema(Long cd_cinema, String nm_cinema, String rua, String numero, String bairro, String cidade,
			String estado, String lotacao) {
		super();
		this.cd_cinema = cd_cinema;
		this.nm_cinema = nm_cinema;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.lotacao = lotacao;
	}

	public Long getCd_cinema() {
		return cd_cinema;
	}

	public void setCd_cinema(Long cd_cinema) {
		this.cd_cinema = cd_cinema;
	}

	public String getNm_cinema() {
		return nm_cinema;
	}

	public void setNm_cinema(String nm_cinema) {
		this.nm_cinema = nm_cinema;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLotacao() {
		return lotacao;
	}

	public void setLotacao(String lotacao) {
		this.lotacao = lotacao;
	}

}
