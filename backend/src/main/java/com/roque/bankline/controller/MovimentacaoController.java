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

import com.roque.bankline.dto.MovimentacaoDto;
import com.roque.bankline.models.Movimentacao;
import com.roque.bankline.repositories.MovimentacaoRepository;
import com.roque.bankline.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private MovimentacaoService service;
	
	@GetMapping
	public List<Movimentacao> findAll(){
		return repository.findAll();
	}
	
	@GetMapping("/conta/{idConta}")
	public List<Movimentacao> findAll(@PathVariable("idConta") Integer idConta){
		return repository.findByIdConta(idConta);
	}
	
	
	@GetMapping(value = "/{id}")
	public Movimentacao findById(@PathVariable("id") Integer id){
		return service.findById(id);
	}
	
	
	@PostMapping
	public void save(@RequestBody MovimentacaoDto movimentacao) {
		service.save(movimentacao);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<String> deleteById(@PathVariable(value = "id") Integer id)  {
	    service.deleteById(id);
	    return ResponseEntity.ok("Movimentacao id: " + id + " deletada com sucesso");

	}
}
