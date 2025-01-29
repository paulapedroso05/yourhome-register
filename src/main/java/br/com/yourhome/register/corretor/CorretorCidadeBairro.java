package br.com.yourhome.register.corretor;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CorretorCidadeBairro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCorretorCidadeBairro;

    @Column(name = "cidadeFk", nullable = false)
    private Integer cidadeFk;

    @Column(name = "bairroFk", nullable = false)
    private Integer bairroFk;

}

