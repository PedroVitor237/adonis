package br.uema.adonis.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import br.uema.adonis.model.Treino;
import br.uema.adonis.repository.TreinoRepository;

@Service
public class TreinoService {

    private final TreinoRepository treinoRepository;

    public TreinoService(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }

    public List<Treino> listarTodos() {
        return treinoRepository.findAll();
    }

    public Optional<Treino> buscarPorId(Integer id) {
        return treinoRepository.findById(id);
    }

    public Treino salvar(Treino treino) {
        return treinoRepository.save(treino);
    }

    public void deletar(Integer id) {
        treinoRepository.deleteById(id);
    }
}