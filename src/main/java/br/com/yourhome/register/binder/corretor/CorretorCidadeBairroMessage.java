package br.com.yourhome.register.binder.corretor;

import lombok.*;

import java.io.Serializable;

@Getter
@ToString
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CorretorCidadeBairroMessage implements Serializable {

    private Integer idCorretorCidadeBairro;

    private Integer cidadeFk;

    private Integer bairroFk;

}

