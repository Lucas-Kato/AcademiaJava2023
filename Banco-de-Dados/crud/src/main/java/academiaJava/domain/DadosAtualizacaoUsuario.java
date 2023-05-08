package academiaJava.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank
                @Email
        String email) {
}
