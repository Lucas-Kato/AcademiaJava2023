package academiaJava.controller;

import academiaJava.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public Usuario cadastroUsuario(@RequestBody DadosCadastroUsuario dados) {
        var usuario = new Usuario(dados);
        return repository.save(usuario);
    }
    @GetMapping
    public List<DadosListagemUsuario> listar() {
        return repository.findAll().stream().map(DadosListagemUsuario::new).toList();
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoUsuario dados) {
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualiar(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        var usuario = repository.getReferenceById(id);
        usuario.excluir();
    }


}
