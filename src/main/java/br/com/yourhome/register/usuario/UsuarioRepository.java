package br.com.yourhome.register.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findUsuarioByCpf(String cpf);

}
