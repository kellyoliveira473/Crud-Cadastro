package com.kelly.Compra_usuario_padaria.business;

import com.kelly.Compra_usuario_padaria.infrasctory.entities.Usuario;
import com.kelly.Compra_usuario_padaria.infrasctory.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void SalvarUsuarioPorId(Usuario usuario) {
        repository.save(usuario);
    }

    public Usuario BuscarUsuarioPorId(Integer id) {
       return repository.findById(id).orElseThrow(
               ()-> new RuntimeException("Id não encontrado em nosso banco de dados")
       );
    }

    public void DeleteUsuarioPorId(Integer id) {
        repository.deleteById(id);
    }

    public Usuario AtualizarUsuarioPorId(Integer id, Usuario usuario) {
        Usuario usuarioEntities = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuario nao encontrado ")
        );
        Usuario usuarioAtual = Usuario.builder()
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntities.getNome())
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntities.getEmail())
                .id(usuario.getId())
                .build();
        return repository.save(usuarioAtual);
    }
    public List<Usuario> listarTodos(){
        return repository.findAll();
    }
}





