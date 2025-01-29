package br.com.yourhome.register.corretor;

import br.com.yourhome.register.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Corretor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCorretor;

    @Column(nullable = false)
    private String telefone;

    private String bio;

    @Column(nullable = false)
    private String creci;

    @With
    @OneToOne
    @JoinColumn(name = "usuarioFk", nullable = false, unique = true)
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "corretorFk", referencedColumnName = "idCorretor")
    private List<CorretorTipoImovel> tiposImoveis;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "corretorFk", referencedColumnName = "idCorretor")
    private List<CorretorConstrutora> construtoras;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "corretorFk", referencedColumnName = "idCorretor")
    private List<CorretorCidadeBairro> cidadesBairros;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "corretorFk", referencedColumnName = "idCorretor")
    private List<CorretorCidade> cidades;

}
