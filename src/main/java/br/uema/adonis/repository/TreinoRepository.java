package br.uema.adonis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.uema.adonis.model.Treino;

@Repository
public interface TreinoRepository 
    extends JpaRepository<Treino, Integer> {
}