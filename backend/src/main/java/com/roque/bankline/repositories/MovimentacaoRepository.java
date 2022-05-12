package com.roque.bankline.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roque.bankline.models.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
	
	public Optional<Movimentacao> findById(Integer id);
	public List<Movimentacao>findByIdConta(Integer idConta);
}
