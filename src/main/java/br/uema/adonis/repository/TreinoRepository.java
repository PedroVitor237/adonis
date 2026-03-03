package br.uema.adonis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.uema.adonis.model.Treino;

public interface TreinoRepository 
    extends JpaRepository<Treino, Integer> {
}