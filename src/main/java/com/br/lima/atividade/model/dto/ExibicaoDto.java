package com.br.lima.atividade.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ExibicaoDto {
	
	private Long cd_cinema;
	private Long cd_filme;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dt_inicio;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dt_fim;

	public ExibicaoDto() {
		super();
	}

	public ExibicaoDto(Date dt_inicio, Date dt_fim, Long cd_cinema, Long cd_filme) {
		super();
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;
		this.cd_cinema = cd_cinema;
		this.cd_filme = cd_filme;
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

	public Long getCd_cinema() {
		return cd_cinema;
	}

	public void setCd_cinema(Long cd_cinema) {
		this.cd_cinema = cd_cinema;
	}

	public Long getCd_filme() {
		return cd_filme;
	}

	public void setCd_filme(Long cd_filme) {
		this.cd_filme = cd_filme;
	}

}
