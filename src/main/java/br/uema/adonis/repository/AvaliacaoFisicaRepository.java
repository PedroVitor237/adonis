package br.uema.adonis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.uema.adonis.model.AvaliacaoFisica;

public interface AvaliacaoFisicaRepository 
    extends JpaRepository<AvaliacaoFisica, Integer> {
}