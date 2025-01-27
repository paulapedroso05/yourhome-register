package br.com.yourhome.register.bairro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

interface BairroRepository extends JpaRepository<Bairro, Integer> {

    Page<Bairro> findBairrosByCodigoIbge(String codigoIbge, Pageable pageable);

}
