package br.uema.adonis.controller;

import br.uema.adonis.model.PersonalTrainer;
import br.uema.adonis.model.Usuario;
import br.uema.adonis.service.PersonalTrainerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/personais")
public class PersonalTrainerWebController {

    private final PersonalTrainerService personalTrainerService;

    public PersonalTrainerWebController(PersonalTrainerService personalTrainerService) {
        this.personalTrainerService = personalTrainerService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("personais", personalTrainerService.listarTodos());
        return "personais";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        PersonalTrainer personal = new PersonalTrainer();
        personal.setUsuario(new Usuario());

        model.addAttribute("personal", personal);
        return "personal-form";
    }

    @PostMapping
    public String salvar(@ModelAttribute PersonalTrainer personal) {
        personalTrainerService.salvar(personal);
        return "redirect:/personais";
    }

    @PostMapping("/{id}")
    public String atualizar(@PathVariable Integer id,
                            @ModelAttribute PersonalTrainer personal) {

        personal.setIdPersonal(id);
        personalTrainerService.salvar(personal);

        return "redirect:/personais";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {

        PersonalTrainer personal = personalTrainerService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Personal não encontrado"));

        model.addAttribute("personal", personal);
        return "personal-form";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        personalTrainerService.deletar(id);
        return "redirect:/personais";
    }
}