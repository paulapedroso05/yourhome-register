package br.com.yourhome.register.corretor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface CorretorRepository extends JpaRepository<Corretor, String> {

    Optional<Corretor> findCorretorByCreci(String creci);

}
