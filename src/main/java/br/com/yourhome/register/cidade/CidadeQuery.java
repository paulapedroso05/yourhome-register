package br.com.yourhome.register.cidade;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CidadeQuery {

    private final CidadeRepository cidadeRepository;

    public Page<Cidade> findAll(Pageable pageable) {
        return cidadeRepository.findAll(pageable);
    }

    public Cidade findOne(String codigoIbge) {
        return cidadeRepository.findCidadeByCodigoIbge(codigoIbge);
    }

}
