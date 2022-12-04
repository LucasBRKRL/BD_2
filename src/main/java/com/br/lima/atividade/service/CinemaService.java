package com.br.lima.atividade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lima.atividade.model.entity.Cinema;
import com.br.lima.atividade.repository.CinemaRepository;


@Service
public class CinemaService {
	
	@Autowired
	private CinemaRepository cinemaRepository;
	
	public Cinema get(Long id) {
        Optional<Cinema> optional = cinemaRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }

        throw new RuntimeException("Cinema não encontrado.");
    }

    public List<Cinema> getAll() {
        return cinemaRepository.findAll();
    }

    public Cinema save(Cinema cinemaNovo) {
        return cinemaRepository.save(cinemaNovo);
    }

    public Cinema update(Long id, Cinema cinemaNovo) {
        Cinema cinemaBanco = get(id);
        
        if(cinemaNovo.getBairro() != null) cinemaBanco.setBairro(cinemaNovo.getBairro());
        if(cinemaNovo.getCidade() != null) cinemaBanco.setCidade(cinemaNovo.getCidade());
        if(cinemaNovo.getEstado() != null) cinemaBanco.setEstado(cinemaNovo.getEstado());
        if(cinemaNovo.getLotacao() != null) cinemaBanco.setLotacao(cinemaNovo.getLotacao());
        if(cinemaNovo.getNm_cinema() != null) cinemaBanco.setNm_cinema(cinemaNovo.getNm_cinema());
        if(cinemaNovo.getNumero() != null) cinemaBanco.setNumero(cinemaNovo.getNumero());
        if(cinemaNovo.getRua() != null) cinemaBanco.setRua(cinemaNovo.getRua());
        
        return cinemaRepository.save(cinemaBanco);
    }

    public void delete(Long id){
        Cinema cinema = get(id);

        cinemaRepository.deleteById(cinema.getCd_cinema());
    }
}
