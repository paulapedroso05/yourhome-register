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
public class CorretorCidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCorretorCidade;

    @Column(name = "cidadeFk", nullable = false)
    private Integer cidadeFk;

}

