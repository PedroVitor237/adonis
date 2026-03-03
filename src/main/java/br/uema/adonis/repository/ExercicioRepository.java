package br.uema.adonis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.uema.adonis.model.Exercicio;

public interface ExercicioRepository 
    extends JpaRepository<Exercicio, Integer> {
}