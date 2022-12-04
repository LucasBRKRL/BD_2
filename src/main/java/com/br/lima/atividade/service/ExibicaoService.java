package com.br.lima.atividade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lima.atividade.model.dto.ExibicaoDto;
import com.br.lima.atividade.model.entity.Cinema;
import com.br.lima.atividade.model.entity.Exibicao;
import com.br.lima.atividade.model.entity.Filme;
import com.br.lima.atividade.repository.CinemaRepository;
import com.br.lima.atividade.repository.ExibicaoRepository;
import com.br.lima.atividade.repository.FilmeRepository;


@Service
public class ExibicaoService {

	@Autowired
	private CinemaRepository cinemaRepository;
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	@Autowired
	private ExibicaoRepository exibicaoRepository;

	public Exibicao get(Long id) {
		Optional<Exibicao> optional = exibicaoRepository.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}

		throw new RuntimeException("Exibição não encontrado.");
	}

	public List<Exibicao> getAll() {
		return exibicaoRepository.findAll();
	}

	public Exibicao save(ExibicaoDto exibicaoNovo) {
		Exibicao exibicao = new Exibicao();
		Optional<Cinema> cinemaBanco = cinemaRepository.findById(exibicaoNovo.getCd_cinema());
		Optional<Filme> filmeBanco = filmeRepository.findById(exibicaoNovo.getCd_filme());
		
		if(!cinemaBanco.isPresent()) throw new RuntimeException("Cinema não encontrado.");
		if(!filmeBanco.isPresent()) throw new RuntimeException("Filme não encontrado.");
		
		exibicao.setDt_inicio(exibicaoNovo.getDt_inicio());
		exibicao.setDt_fim(exibicaoNovo.getDt_fim());
		exibicao.setCinema(cinemaBanco.get());
		exibicao.setFilme(filmeBanco.get());
		
		return exibicaoRepository.save(exibicao);
	}

	public Exibicao update(Long id, Exibicao exibicaoNovo) {
		Exibicao exibicaoBanco = get(id);
		
		if(exibicaoNovo.getDt_inicio() != null) exibicaoBanco.setDt_inicio(exibicaoNovo.getDt_inicio());
		if(exibicaoNovo.getDt_fim() != null) exibicaoBanco.setDt_fim(exibicaoNovo.getDt_fim());

		return exibicaoRepository.save(exibicaoBanco);
	}

	public void delete(Long id) {
		Exibicao exibicaoBanco = get(id);

		exibicaoRepository.deleteById(exibicaoBanco.getCd_exibicao());
	}
}
