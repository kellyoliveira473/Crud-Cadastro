package com.kelly.Compra_usuario_padaria.business;

import com.kelly.Compra_usuario_padaria.infrasctory.entities.Padaria;
import com.kelly.Compra_usuario_padaria.infrasctory.entities.Usuario;
import com.kelly.Compra_usuario_padaria.infrasctory.repository.PadariaRepository;
import org.springframework.stereotype.Service;

@Service
public class PadariaService {
    private final PadariaRepository repository;

    public PadariaService(PadariaRepository repository) {
        this.repository = repository;
    }
    public void SalvarPadariaPorId(Padaria padaria){
        repository.saveAndFlush(padaria);


    }
    public Padaria BuscarPorId(Long id){
        return repository.findById(id).orElseThrow(
                ()->new RuntimeException("Produto nao encontrado ")
        );
    }
    public void DeletarPadariaPorId(Long id ){
        repository.deleteById(id);
    }
    public Padaria AtualizarPadariaPorId(Long id,Padaria padaria){
        Padaria padariaEntities = repository.findById(id).orElseThrow(
                ()-> new RuntimeException("Id nao encontrado")
        );
        Padaria padariaAtual = Padaria.builder()
                .nome(padaria.getNome()!= null ? padaria.getNome():
                        padariaEntities.getNome())
                .valor(padaria.getValor()!=null ?padaria.getValor():
                        padariaEntities.getValor())
                .id(padariaEntities.getId())
                .build();
        return repository.save(padariaAtual);
    }
}
