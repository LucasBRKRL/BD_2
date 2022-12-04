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

import com.br.lima.atividade.model.entity.Filme;
import com.br.lima.atividade.service.FilmeService;


@RestController
@RequestMapping(value = "/api/filme")
public class FilmeController {
	
	private FilmeService service;

	public FilmeController(FilmeService service) {
		this.service = service;
	}
	
	@GetMapping
    public ResponseEntity<Iterable<Filme>> getAllImoveis() {
        Iterable<Filme> list = service.getAll();

        return new ResponseEntity<Iterable<Filme>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Filme> getImovel(@PathVariable Long id) {
        Filme obj = service.get(id);

        return new ResponseEntity<Filme>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Filme> saveImovel(@RequestBody Filme body) {
        Filme obj = service.save(body);

        return new ResponseEntity<Filme>(obj, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Filme> updateImovel(@PathVariable Long id, @RequestBody Filme body) {
        Filme obj = service.update(id, body);

        return new ResponseEntity<Filme>(obj, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteImovel(@PathVariable Long id) {
        service.delete(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }	
}
