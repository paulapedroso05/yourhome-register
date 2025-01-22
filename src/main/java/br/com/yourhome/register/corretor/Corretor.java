package br.com.yourhome.register.corretor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Corretor implements Serializable {

    @Id
    private String documento;

    private String nome;

    private String email;

    private String telefone;

    private String creci;

    private String bio;

}
