package com.kelly.Compra_usuario_padaria.controller;

import com.kelly.Compra_usuario_padaria.business.PadariaService;
import com.kelly.Compra_usuario_padaria.infrasctory.entities.Padaria;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/padaria")
@RequiredArgsConstructor
public class PadariaController {

    private final PadariaService padariaService;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Padaria padaria){
        padariaService.SalvarPadariaPorId(padaria);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Padaria> buscar(@PathVariable Long id){
        Padaria padaria = padariaService.BuscarPorId(id);
        return ResponseEntity.ok(padaria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        padariaService.DeletarPadariaPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody Padaria padaria){
        padariaService.AtualizarPadariaPorId(id, padaria);
        return ResponseEntity.ok().build();
    }
}
