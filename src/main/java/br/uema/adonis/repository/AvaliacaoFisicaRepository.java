package br.uema.adonis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.uema.adonis.model.AvaliacaoFisica;

@Repository
public interface AvaliacaoFisicaRepository 
    extends JpaRepository<AvaliacaoFisica, Integer> {
}