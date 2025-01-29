package br.com.yourhome.register.binder.corretor;

import br.com.yourhome.register.corretor.Corretor;
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

    private List<CorretorTipoImovelMessage> tiposImoveis;

    private List<CorretorConstrutoraMessage> construtoras;

    private List<CorretorCidadeBairroMessage> cidadesBairros;

    private List<CorretorCidadeMessage> cidades;

    public static CorretorCadastradoMessage of(Corretor corretor) {
        return new CorretorCadastradoMessage(corretor.getCreci(), corretor.getUsuario().getNome(),
                corretor.getUsuario().getEmail(), corretor.getTelefone(), corretor.getBio(),
                corretor.getTiposImoveis().stream().map(tipoImovel ->
                        CorretorTipoImovelMessage.of(tipoImovel.getIdCorretorTipoImovel(), tipoImovel.getNome())).toList(),
                corretor.getConstrutoras().stream().map(construtora ->
                        CorretorConstrutoraMessage.of(construtora.getIdCorretorConstrutora(), construtora.getNome())).toList(),
                corretor.getCidadesBairros().stream().map(cidadeBairro ->
                        CorretorCidadeBairroMessage.of(cidadeBairro.getIdCorretorCidadeBairro(), cidadeBairro.getCidadeFk(), cidadeBairro.getBairroFk())).toList(),
                corretor.getCidades().stream().map(cidade -> CorretorCidadeMessage.of(cidade.getIdCorretorCidade(), cidade.getCidadeFk())).toList());
    }

}
