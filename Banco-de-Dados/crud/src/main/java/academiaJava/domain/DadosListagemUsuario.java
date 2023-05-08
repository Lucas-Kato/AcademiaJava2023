package academiaJava.domain;

import academiaJava.domain.Usuario;

public record DadosListagemUsuario(Long id, String nome, String emai) {
    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}
