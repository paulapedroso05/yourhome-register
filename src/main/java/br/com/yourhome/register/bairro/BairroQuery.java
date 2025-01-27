package br.com.yourhome.register.bairro;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class BairroQuery {

    private final BairroRepository bairroRepository;

    public Page<Bairro> findAll(String codigoIbge, Pageable pageable) {
        return bairroRepository.findBairrosByCodigoIbge(codigoIbge, pageable);
    }

}
