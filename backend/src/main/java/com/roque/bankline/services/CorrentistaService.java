package com.roque.bankline.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roque.bankline.dto.CorrentistaDto;
import com.roque.bankline.models.Conta;
import com.roque.bankline.models.Correntista;
import com.roque.bankline.repositories.CorrentistaRepository;

@Service
public class CorrentistaService {
	@Autowired
	private CorrentistaRepository repository;
	
	public void save(CorrentistaDto novoCorrentista) {
		Correntista correntista = new Correntista();
		correntista.setCpf(novoCorrentista.getCpf());
		correntista.setNome(novoCorrentista.getNome());
		
		Conta conta = new Conta();
		conta.setSaldo(0.0);
		conta.setNumero(new Date().getTime());
		
		correntista.setConta(conta);
		repository.save(correntista);
	}
	
	public Correntista findById(Integer id) {
		return repository.findById(id).get();		
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
