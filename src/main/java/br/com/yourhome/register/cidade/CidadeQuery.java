package br.com.yourhome.register.cidade;

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
public class CidadeQuery {

    private final CidadeRepository cidadeRepository;

    private final MessageSourceHelper messageSourceHelper;

    public Page<Cidade> findAll(Pageable pageable) {
        return cidadeRepository.findAll(pageable);
    }

    public Cidade findOne(String codigoIbge) {
        return cidadeRepository.findCidadeByCodigoIbge(codigoIbge);
    }

    public Cidade findById(Integer id) {
        return cidadeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(messageSourceHelper.getMessage("cidade.nao.encontrada", id)));
    }

}
