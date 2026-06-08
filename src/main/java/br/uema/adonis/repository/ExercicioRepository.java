package br.uema.adonis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.uema.adonis.model.Exercicio;

@Repository
public interface ExercicioRepository 
    extends JpaRepository<Exercicio, Integer> {
}