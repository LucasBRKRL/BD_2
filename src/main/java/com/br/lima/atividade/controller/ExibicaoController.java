package com.br.lima.atividade.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.lima.atividade.model.dto.ExibicaoDto;
import com.br.lima.atividade.model.entity.Exibicao;
import com.br.lima.atividade.service.ExibicaoService;


@RestController
@RequestMapping(value = "/api/exibicao")
public class ExibicaoController {
	
	private ExibicaoService service;

	public ExibicaoController(ExibicaoService service) {
		this.service = service;
	}
	
	@GetMapping
    public ResponseEntity<Iterable<Exibicao>> getAllImoveis() {
        Iterable<Exibicao> list = service.getAll();

        return new ResponseEntity<Iterable<Exibicao>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Exibicao> getImovel(@PathVariable Long id) {
    	Exibicao obj = service.get(id);

        return new ResponseEntity<Exibicao>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Exibicao> saveImovel(@RequestBody ExibicaoDto body) {
    	Exibicao obj = service.save(body);

        return new ResponseEntity<Exibicao>(obj, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Exibicao> updateImovel(@PathVariable Long id, @RequestBody Exibicao body) {
    	Exibicao obj = service.update(id, body);

        return new ResponseEntity<Exibicao>(obj, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteImovel(@PathVariable Long id) {
        service.delete(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }	
}
