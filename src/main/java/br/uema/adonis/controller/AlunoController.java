package br.uema.adonis.controller;

import br.uema.adonis.model.Aluno;
import br.uema.adonis.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }

    @PostMapping
    public Aluno criar(@RequestBody Aluno aluno) {
        return alunoService.salvar(aluno);
    }

    @GetMapping("/{id}")
    public Aluno buscarPorId(@PathVariable Integer id) {
        return alunoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        alunoService.deletar(id);
    }
}