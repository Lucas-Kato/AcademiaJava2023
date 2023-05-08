package academiaJava.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuario")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario{
        @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String email;
        private Boolean ativo;

        public Usuario(DadosCadastroUsuario dados) {
                this.nome = dados.nome();
                this.email = dados.email();
        }

        public void atualiar(DadosAtualizacaoUsuario dados) {
                if(dados.nome() != null) {
                        this.nome = dados.nome();
                }
                if(dados.email() != null) {
                        this.email = dados.email();
                }
        }
        public void excluir(){
                this.ativo = false;
        }


}
