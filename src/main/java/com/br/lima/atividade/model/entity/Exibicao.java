package com.br.lima.atividade.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_exibicao")
public class Exibicao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cd_exibicao;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dt_inicio;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dt_fim;
	
	@ManyToOne
    @JoinColumn(name = "cd_cinema")
	private Cinema cinema;

	@ManyToOne
    @JoinColumn(name = "cd_filme")
	private Filme filme;

	public Exibicao() {
		super();
	}

	
	public Exibicao(Long cd_exibicao, Date dt_inicio, Date dt_fim, Cinema cinema, Filme filme) {
		super();
		this.cd_exibicao = cd_exibicao;
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;
		this.cinema = cinema;
		this.filme = filme;
	}


	public Long getCd_exibicao() {
		return cd_exibicao;
	}


	public void setCd_exibicao(Long cd_exibicao) {
		this.cd_exibicao = cd_exibicao;
	}


	public Date getDt_inicio() {
		return dt_inicio;
	}


	public void setDt_inicio(Date dt_inicio) {
		this.dt_inicio = dt_inicio;
	}


	public Date getDt_fim() {
		return dt_fim;
	}


	public void setDt_fim(Date dt_fim) {
		this.dt_fim = dt_fim;
	}


	public Cinema getCinema() {
		return cinema;
	}


	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}


	public Filme getFilme() {
		return filme;
	}


	public void setFilme(Filme filme) {
		this.filme = filme;
	}
}
