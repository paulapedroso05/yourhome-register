package br.com.yourhome.register.bairro;

import br.com.yourhome.register.configuracao.MessageSourceHelper;
import br.com.yourhome.register.configuracao.exception.ResourceNotFoundException;
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

    private final MessageSourceHelper messageSourceHelper;

    public Page<Bairro> findAll(String codigoIbge, Pageable pageable) {
        return bairroRepository.findBairrosByCodigoIbge(codigoIbge, pageable);
    }

    public Bairro findById(Integer id) {
        return bairroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(messageSourceHelper.getMessage("bairro.nao.encontrado", id)));
    }

}
