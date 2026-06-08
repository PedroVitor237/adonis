package br.uema.adonis.repository;

import br.uema.adonis.model.PersonalTrainer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalTrainerRepository extends JpaRepository<PersonalTrainer, Integer> {
}