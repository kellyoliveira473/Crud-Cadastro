package com.kelly.Compra_usuario_padaria.controller;

import com.kelly.Compra_usuario_padaria.business.UsuarioService;
import com.kelly.Compra_usuario_padaria.infrasctory.entities.Usuario;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<Void>SalvarUsuario(@RequestBody Usuario usuario){
       usuarioService.SalvarUsuarioPorId(usuario);
       return ResponseEntity.ok().build();
    }
    @GetMapping("/todos")
    public ResponseEntity<Void >BuscarUsuario(@RequestParam Integer id){
        usuarioService.BuscarUsuarioPorId(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping
    public ResponseEntity<Void>DeleteUsuario(@RequestParam Integer id){
        usuarioService.DeleteUsuarioPorId(id);
        return ResponseEntity.ok().build() ;
    }
    @PutMapping
    public ResponseEntity<Void >AtualizarUsuario(@RequestParam Integer id ,@RequestBody Usuario usuario){
        usuarioService.AtualizarUsuarioPorId(id,usuario);
        return ResponseEntity.ok().build();

    }
}
