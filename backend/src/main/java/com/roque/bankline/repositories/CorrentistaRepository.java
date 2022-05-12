package com.roque.bankline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roque.bankline.models.Correntista;

@Repository
public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {


}
