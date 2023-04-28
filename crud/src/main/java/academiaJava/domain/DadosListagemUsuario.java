package academiaJava.domain;

public record DadosListagemUsuario(Long id, String nome, String emai) {
    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}
