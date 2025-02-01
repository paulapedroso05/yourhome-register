package br.com.yourhome.register.binder.corretor;

import br.com.yourhome.register.corretor.Corretor;
import br.com.yourhome.register.corretor.CorretorConstrutora;
import br.com.yourhome.register.corretor.CorretorTipoImovel;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CorretorCadastradoMessage implements Serializable {

    private String creci;

    private String nome;

    private String email;

    private String telefone;

    private String bio;

    private List<String> tiposImoveis;

    private List<String> construtoras;

    private List<String> cidades;

    private List<String> bairros;

    public static CorretorCadastradoMessage of(Corretor corretor, List<String> cidades, List<String> bairros) {
        return new CorretorCadastradoMessage(corretor.getCreci(), corretor.getUsuario().getNome(),
                corretor.getUsuario().getEmail(), corretor.getTelefone(), corretor.getBio(),
                corretor.getTiposImoveis().stream().map(CorretorTipoImovel::getNome).toList(),
                corretor.getConstrutoras().stream().map(CorretorConstrutora::getNome).toList(),
                cidades, bairros);
    }

}
