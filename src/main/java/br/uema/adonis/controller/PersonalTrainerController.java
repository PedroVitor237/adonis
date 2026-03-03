package br.uema.adonis.controller;

import br.uema.adonis.model.PersonalTrainer;
import br.uema.adonis.service.PersonalTrainerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal-trainers")
public class PersonalTrainerController {

    private final PersonalTrainerService personalTrainerService;

    public PersonalTrainerController(PersonalTrainerService personalTrainerService) {
        this.personalTrainerService = personalTrainerService;
    }

    @GetMapping
    public List<PersonalTrainer> listarTodos() {
        return personalTrainerService.listarTodos();
    }

    @PostMapping
    public PersonalTrainer criar(@RequestBody PersonalTrainer personalTrainer) {
        return personalTrainerService.salvar(personalTrainer);
    }

    @GetMapping("/{id}")
    public PersonalTrainer buscarPorId(@PathVariable Integer id) {
        return personalTrainerService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Personal Trainer não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        personalTrainerService.deletar(id);
    }
}