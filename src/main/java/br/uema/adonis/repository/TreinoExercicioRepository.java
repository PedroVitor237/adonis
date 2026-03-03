package br.uema.adonis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.uema.adonis.model.TreinoExercicio;
import br.uema.adonis.model.TreinoExercicioId;

public interface TreinoExercicioRepository 
    extends JpaRepository<TreinoExercicio, TreinoExercicioId> {
}