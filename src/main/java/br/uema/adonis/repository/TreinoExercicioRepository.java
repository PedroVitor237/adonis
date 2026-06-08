package br.uema.adonis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.uema.adonis.model.TreinoExercicio;
import br.uema.adonis.model.TreinoExercicioId;

@Repository
public interface TreinoExercicioRepository 
    extends JpaRepository<TreinoExercicio, TreinoExercicioId> {
}