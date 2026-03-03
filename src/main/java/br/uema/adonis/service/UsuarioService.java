package br.uema.adonis.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import br.uema.adonis.model.Usuario;
import br.uema.adonis.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Listar todos
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Buscar por ID
    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    // Salvar
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Deletar
    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}