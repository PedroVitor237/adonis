package br.uema.adonis.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import br.uema.adonis.model.TreinoExercicio;
import br.uema.adonis.model.TreinoExercicioId;
import br.uema.adonis.repository.TreinoExercicioRepository;

@Service
public class TreinoExercicioService {

    private final TreinoExercicioRepository treinoExercicioRepository;

    public TreinoExercicioService(TreinoExercicioRepository treinoExercicioRepository) {
        this.treinoExercicioRepository = treinoExercicioRepository;
    }

    public List<TreinoExercicio> listarTodos() {
        return treinoExercicioRepository.findAll();
    }

    public Optional<TreinoExercicio> buscarPorId(TreinoExercicioId id) {
        return treinoExercicioRepository.findById(id);
    }

    public TreinoExercicio salvar(TreinoExercicio treinoExercicio) {
        return treinoExercicioRepository.save(treinoExercicio);
    }

    public void deletar(TreinoExercicioId id) {
        treinoExercicioRepository.deleteById(id);
    }
}