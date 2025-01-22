package br.com.yourhome.register.corretor;

import br.com.yourhome.register.binder.corretor.CorretorCadastradoMessage;
import br.com.yourhome.register.binder.corretor.CorretorProducer;
import br.com.yourhome.register.configuracao.MessageSourceHelper;
import br.com.yourhome.register.configuracao.exception.ConflictException;
import br.com.yourhome.register.configuracao.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.yourhome.register.configuracao.ObjectHelper.copyNonNullProperties;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class CorretorCommand {

    private final CorretorProducer corretorProducer;

    private final CorretorRepository corretorRepository;

    private final MessageSourceHelper messageSourceHelper;

    public Corretor salvar(Corretor corretor) {
        corretorRepository.findById(corretor.getDocumento()).ifPresent(existente -> {
            throw new ConflictException(messageSourceHelper.getMessage("corretor.conflito", corretor.getDocumento()));
        });
        Corretor novoCorretor = corretorRepository.save(corretor);
        corretorProducer.output(CorretorCadastradoMessage.of(novoCorretor));
        return novoCorretor;
    }

    public Corretor atualizar(String documento, Corretor corretor) {
        Corretor corretorDb = findOne(documento);
        copyNonNullProperties(corretor, corretorDb);
        return corretorRepository.save(corretor);
    }

    private Corretor findOne(String documento) {
        return corretorRepository.findById(documento).orElseThrow(() -> new ResourceNotFoundException(messageSourceHelper.getMessage("corretor.nao.encontrado", documento)));
    }

}
