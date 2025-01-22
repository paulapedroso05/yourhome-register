package br.com.yourhome.register.cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Cliente {

    @Id
    private String documento;

    private String nome;

    private String email;

    private String telefone;

}
