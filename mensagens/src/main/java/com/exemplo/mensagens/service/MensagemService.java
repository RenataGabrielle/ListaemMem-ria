package com.exemplo.mensagens.service;

import com.exemplo.mensagens.model.Mensagem;
import com.exemplo.mensagens.repository.MensagemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MensagemService {

    private final MensagemRepository repository;

    // Lista em memória para fase 1
    private final List<Mensagem> listaMemoria = new ArrayList<>();
    private Long contadorId = 1L;

    public MensagemService(MensagemRepository repository) {
        this.repository = repository;
    }

    // ===== FASE 1: Lista em memória =====
    public Mensagem salvarMemoria(Mensagem mensagem) {
        mensagem.setId(contadorId++);
        listaMemoria.add(mensagem);
        return mensagem;
    }

    public List<Mensagem> listarTodosMemoria() {
        return listaMemoria;
    }

    public Optional<Mensagem> buscarPorIdMemoria(Long id) {
        return listaMemoria.stream().filter(m -> m.getId().equals(id)).findFirst();
    }

    public Mensagem atualizarMemoria(Long id, Mensagem mensagemAtualizada) {
        Optional<Mensagem> optional = buscarPorIdMemoria(id);
        if (optional.isPresent()) {
            Mensagem existente = optional.get();
            existente.setTexto(mensagemAtualizada.getTexto());
            return existente;
        } else {
            throw new RuntimeException("Mensagem não encontrada na memória");
        }
    }

    public void deletarMemoria(Long id) {
        listaMemoria.removeIf(m -> m.getId().equals(id));
    }

    // ===== FASE 2: Persistência com JPA =====
    public Mensagem salvar(Mensagem mensagem) {
        return repository.save(mensagem);
    }

    public List<Mensagem> listarTodos() {
        return repository.findAll();
    }

    public Optional<Mensagem> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Mensagem atualizar(Long id, Mensagem mensagemAtualizada) {
        Optional<Mensagem> optional = repository.findById(id);
        if (optional.isPresent()) {
            Mensagem existente = optional.get();
            existente.setTexto(mensagemAtualizada.getTexto());
            return repository.save(existente);
        } else {
            throw new RuntimeException("Mensagem não encontrada");
        }
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
