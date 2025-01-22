package br.com.yourhome.register.binder.corretor;

import br.com.yourhome.register.corretor.Corretor;
import lombok.*;

import java.io.Serializable;

@Getter
@ToString
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CorretorCadastradoMessage implements Serializable {

    private String documento;

    private String nome;

    private String email;

    private String telefone;

    private String creci;

    private String bio;

    public static CorretorCadastradoMessage of(Corretor corretor) {
        return new CorretorCadastradoMessage(corretor.getDocumento(), corretor.getNome(), corretor.getEmail(), corretor.getTelefone(), corretor.getCreci(), corretor.getBio());
    }

}
