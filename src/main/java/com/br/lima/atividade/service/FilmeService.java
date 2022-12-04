package com.br.lima.atividade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lima.atividade.model.entity.Filme;
import com.br.lima.atividade.repository.FilmeRepository;


@Service
public class FilmeService {
	
	@Autowired
	private FilmeRepository filmeRepository;

	public Filme get(Long id) {
        Optional<Filme> optional = filmeRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }

        throw new RuntimeException("Filme não encontrado.");
    }

    public List<Filme> getAll() {
        return filmeRepository.findAll();
    }

    public Filme save(Filme filmeNovo) {
        return filmeRepository.save(filmeNovo);
    }

    public Filme update(Long id, Filme filmeNovo) {
        Filme filmeBanco = get(id);
        
        if(filmeNovo.getAno() != null) filmeBanco.setAno(filmeNovo.getAno());
        if(filmeNovo.getFaixaEtaria() != null) filmeBanco.setFaixaEtaria(filmeNovo.getFaixaEtaria());
        if(filmeNovo.getGenero() != null) filmeBanco.setGenero(filmeNovo.getGenero());
        if(filmeNovo.getTitulo() != null) filmeBanco.setTitulo(filmeNovo.getTitulo());

        return filmeRepository.save(filmeBanco);
    }

    public void delete(Long id){
        Filme filme = get(id);

        filmeRepository.deleteById(filme.getCd_filme());
    }
}
