package com.exemplo.mensagens.controller;

import com.exemplo.mensagens.model.Mensagem;
import com.exemplo.mensagens.service.MensagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {

    private final MensagemService service;

    public MensagemController(MensagemService service) {
        this.service = service;
    }

    // ===== FASE 1: Lista em memória =====
    @PostMapping("/memoria")
    public Mensagem criarMemoria(@RequestBody Mensagem mensagem) {
        return service.salvarMemoria(mensagem);
    }

    @GetMapping("/memoria")
    public List<Mensagem> listarMemoria() {
        return service.listarTodosMemoria();
    }

    @GetMapping("/memoria/{id}")
    public ResponseEntity<Mensagem> buscarPorIdMemoria(@PathVariable Long id) {
        return service.buscarPorIdMemoria(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/memoria/{id}")
    public Mensagem atualizarMemoria(@PathVariable Long id, @RequestBody Mensagem mensagem) {
        return service.atualizarMemoria(id, mensagem);
    }

    @DeleteMapping("/memoria/{id}")
    public void deletarMemoria(@PathVariable Long id) {
        service.deletarMemoria(id);
    }

    // ===== FASE 2: Persistência com JPA =====
    @PostMapping
    public Mensagem criar(@RequestBody Mensagem mensagem) {
        return service.salvar(mensagem);
    }

    @GetMapping
    public List<Mensagem> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensagem> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Mensagem atualizar(@PathVariable Long id, @RequestBody Mensagem mensagem) {
        return service.atualizar(id, mensagem);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
