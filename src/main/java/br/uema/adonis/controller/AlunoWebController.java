package br.uema.adonis.controller;

import br.uema.adonis.model.Aluno;
import br.uema.adonis.model.Usuario;
import br.uema.adonis.model.StatusUsuario;
import br.uema.adonis.service.AlunoService;
import br.uema.adonis.service.PersonalTrainerService;
import br.uema.adonis.model.TipoUsuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/alunos")
public class AlunoWebController {

    private final AlunoService alunoService;
    private final PersonalTrainerService personalTrainerService;

    public AlunoWebController(AlunoService alunoService,
                              PersonalTrainerService personalTrainerService) {
        this.alunoService = alunoService;
        this.personalTrainerService = personalTrainerService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alunos", alunoService.listarTodos());
        return "alunos";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        Aluno aluno = new Aluno();
        aluno.setUsuario(new Usuario());
        model.addAttribute("aluno", aluno);

        /* model.addAttribute("aluno", new Aluno());
        model.addAttribute("personais", personalTrainerService.listarTodos());
        */
        return "aluno-form";
    }

    /* @PostMapping
    public String salvar(@ModelAttribute Aluno aluno) {
        alunoService.salvar(aluno);
        return "redirect:/alunos";
    } */
    /* @PostMapping
    public String salvar(
            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam String senha
    ) {

        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);

        Aluno aluno = new Aluno();
        aluno.setNome(nome);

        alunoService.criarAlunoComUsuario(usuario, aluno);

        return "redirect:/alunos";
    } */
    @PostMapping
    public String salvar(@ModelAttribute Aluno aluno) {

        aluno.getUsuario().setTipoUsuario(TipoUsuario.ALUNO);
        aluno.getUsuario().setStatus(StatusUsuario.ATIVO);
        //Implementação futura: definir status como "enum"
        /* aluno.getUsuario().setStatus(StatusUsuario.ATIVO); */

        alunoService.salvar(aluno);

        return "redirect:/alunos";
    }

    @PostMapping("/{id}")
    public String atualizar(@PathVariable Integer id,
                        @ModelAttribute Aluno aluno) {
    aluno.setIdAluno(id);
    alunoService.salvar(aluno);
    return "redirect:/alunos";
}

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Aluno aluno = alunoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        model.addAttribute("aluno", aluno);
        model.addAttribute("personais", personalTrainerService.listarTodos());
        return "aluno-form";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        alunoService.deletar(id);
        return "redirect:/alunos";
    }
}
