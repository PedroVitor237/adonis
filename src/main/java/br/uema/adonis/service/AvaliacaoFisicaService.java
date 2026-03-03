package br.uema.adonis.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional; 

import br.uema.adonis.model.AvaliacaoFisica;
import br.uema.adonis.repository.AvaliacaoFisicaRepository;

@Service
public class AvaliacaoFisicaService {

    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    public AvaliacaoFisicaService(AvaliacaoFisicaRepository avaliacaoFisicaRepository) {
        this.avaliacaoFisicaRepository = avaliacaoFisicaRepository;
    }

    public List<AvaliacaoFisica> listarTodos() {
        return avaliacaoFisicaRepository.findAll();
    }

    public Optional<AvaliacaoFisica> buscarPorId(Integer id) {
        return avaliacaoFisicaRepository.findById(id);
    }

    public AvaliacaoFisica salvar(AvaliacaoFisica avaliacaoFisica) {
        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    public void deletar(Integer id) {
        avaliacaoFisicaRepository.deleteById(id);
    }
}