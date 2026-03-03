package br.uema.adonis.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

import br.uema.adonis.model.Aluno;
import br.uema.adonis.model.StatusUsuario;
import br.uema.adonis.model.TipoUsuario;
import br.uema.adonis.model.Usuario;
import br.uema.adonis.repository.AlunoRepository;
/* import br.uema.adonis.repository.UsuarioRepository; */

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    /* private final UsuarioRepository usuarioRepository; */

    /* public AlunoService(AlunoRepository alunoRepository,  UsuarioRepository usuarioRepository) {
        this.alunoRepository = alunoRepository;
        this.usuarioRepository = usuarioRepository;
    } */
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarPorId(Integer id) {
        return alunoRepository.findById(id);
    }

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void deletar(Integer id) {
        alunoRepository.deleteById(id);
    }

    @Transactional
    public Aluno criarAlunoComUsuario(Usuario usuario, Aluno aluno) {

        usuario.setTipoUsuario(TipoUsuario.ALUNO);
        usuario.setStatus(StatusUsuario.ATIVO);

        /* Usuario usuarioSalvo = usuarioRepository.save(usuario);

        aluno.setUsuario(usuarioSalvo); */
        aluno.setUsuario(usuario);

        return alunoRepository.save(aluno);
    }
}