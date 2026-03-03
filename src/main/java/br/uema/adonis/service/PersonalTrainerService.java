/* package br.uema.adonis.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

import br.uema.adonis.model.PersonalTrainer;
import br.uema.adonis.model.StatusUsuario;
import br.uema.adonis.model.TipoUsuario;
import br.uema.adonis.model.Usuario;
import br.uema.adonis.repository.PersonalTrainerRepository;
import br.uema.adonis.repository.UsuarioRepository;

@Service
public class PersonalTrainerService {

    private final PersonalTrainerRepository personalTrainerRepository;
    private final UsuarioRepository usuarioRepository;

    public PersonalTrainerService(PersonalTrainerRepository personalTrainerRepository, UsuarioRepository usuarioRepository) {
        this.personalTrainerRepository = personalTrainerRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // Listar todos
    public List<PersonalTrainer> listarTodos() {
        return personalTrainerRepository.findAll();
    }

    // Buscar por ID
    public Optional<PersonalTrainer> buscarPorId(Integer id) {
        return personalTrainerRepository.findById(id);
    }

    // Salvar
    public PersonalTrainer salvar(PersonalTrainer personalTrainer) {
        return personalTrainerRepository.save(personalTrainer);
    }

    // Deletar
    public void deletar(Integer id) {
        personalTrainerRepository.deleteById(id);
    }
        
    @Transactional
    public PersonalTrainer criarPersonalComUsuario(Usuario usuario, PersonalTrainer personal) {

        usuario.setTipoUsuario(TipoUsuario.PERSONAL);
        usuario.setStatus(StatusUsuario.ATIVO);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        personal.setUsuario(usuarioSalvo);

        return personalTrainerRepository.save(personal);
    }
}  */

package br.uema.adonis.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import br.uema.adonis.model.PersonalTrainer;
import br.uema.adonis.model.StatusUsuario;
import br.uema.adonis.model.TipoUsuario;
import br.uema.adonis.repository.PersonalTrainerRepository;

@Service
public class PersonalTrainerService {

    private final PersonalTrainerRepository personalTrainerRepository;

    public PersonalTrainerService(PersonalTrainerRepository personalTrainerRepository) {
        this.personalTrainerRepository = personalTrainerRepository;
    }

    public List<PersonalTrainer> listarTodos() {
        return personalTrainerRepository.findAll();
    }

    public Optional<PersonalTrainer> buscarPorId(Integer id) {
        return personalTrainerRepository.findById(id);
    }

    public PersonalTrainer salvar(PersonalTrainer personalTrainer) {

        // Define automaticamente tipo e status
        personalTrainer.getUsuario().setTipoUsuario(TipoUsuario.PERSONAL);
        personalTrainer.getUsuario().setStatus(StatusUsuario.ATIVO);

        return personalTrainerRepository.save(personalTrainer);
    }

    public void deletar(Integer id) {
        personalTrainerRepository.deleteById(id);
    }
} 