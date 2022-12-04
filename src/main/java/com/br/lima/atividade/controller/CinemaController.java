package com.br.lima.atividade.controller;

import java.util.List;

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

import com.br.lima.atividade.model.entity.Cinema;
import com.br.lima.atividade.service.CinemaService;


@RestController
@RequestMapping(value = "/api/cinema")
public class CinemaController {

	private CinemaService service;

	public CinemaController(CinemaService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Cinema>> getAllImoveis() {
		List<Cinema> list = service.getAll();

		return new ResponseEntity<List<Cinema>>(list, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cinema> getImovel(@PathVariable Long id) {
		Cinema obj = service.get(id);

		return new ResponseEntity<Cinema>(obj, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cinema> saveImovel(@RequestBody Cinema body) {
		Cinema obj = service.save(body);

		return new ResponseEntity<Cinema>(obj, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Cinema> updateImovel(@PathVariable Long id, @RequestBody Cinema body) {
		Cinema obj = service.update(id, body);

		return new ResponseEntity<Cinema>(obj, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteImovel(@PathVariable Long id) {
		service.delete(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
