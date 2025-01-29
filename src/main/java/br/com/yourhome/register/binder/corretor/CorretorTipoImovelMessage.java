package br.com.yourhome.register.binder.corretor;

import lombok.*;

import java.io.Serializable;

@Getter
@ToString
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CorretorTipoImovelMessage implements Serializable {

    private Integer idCorretorTipoImovel;

    private String nome;

}

