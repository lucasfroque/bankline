package com.roque.bankline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roque.bankline.dto.CorrentistaDto;
import com.roque.bankline.models.Correntista;
import com.roque.bankline.repositories.CorrentistaRepository;
import com.roque.bankline.services.CorrentistaService;


@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
	@Autowired
	private CorrentistaRepository repository;
	
	@Autowired
	private CorrentistaService service;
	
	@GetMapping
	public List<Correntista> findAll(){
		return repository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Correntista findBydId(@PathVariable Integer id){
		return service.findById(id);
	}
	
	
	@PostMapping
	public void save(@RequestBody CorrentistaDto correntista) {
		service.save(correntista);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Integer> deleteById(@PathVariable(value = "id") Integer id)  {
	    service.deleteById(id);
	    return ResponseEntity.ok(id);

	}
	
}
