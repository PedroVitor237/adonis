package br.uema.adonis.repository;

import br.uema.adonis.model.PersonalTrainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalTrainerRepository extends JpaRepository<PersonalTrainer, Integer> {
}