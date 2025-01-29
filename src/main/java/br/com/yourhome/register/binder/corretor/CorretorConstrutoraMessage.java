package br.com.yourhome.register.binder.corretor;

import lombok.*;

import java.io.Serializable;

@Getter
@ToString
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CorretorConstrutoraMessage implements Serializable {

    private Integer idCorretorConstrutora;

    private String nome;

}

