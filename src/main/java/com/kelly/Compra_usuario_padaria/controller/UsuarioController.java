package com.kelly.Compra_usuario_padaria.controller;

import com.kelly.Compra_usuario_padaria.business.UsuarioService;
import com.kelly.Compra_usuario_padaria.infrasctory.entities.Usuario;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){
        usuarioService.SalvarUsuarioPorId(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Integer id){
        Usuario usuario = usuarioService.BuscarUsuarioPorId(id);
        return ResponseEntity.ok(usuarioService.BuscarUsuarioPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id){
        usuarioService.DeleteUsuarioPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario){
        usuarioService.AtualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }
}
