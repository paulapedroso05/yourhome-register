package br.com.yourhome.register.corretor;

import br.com.yourhome.register.bairro.BairroQuery;
import br.com.yourhome.register.binder.corretor.CorretorCadastradoMessage;
import br.com.yourhome.register.binder.corretor.CorretorProducer;
import br.com.yourhome.register.cidade.CidadeQuery;
import br.com.yourhome.register.configuracao.MessageSourceHelper;
import br.com.yourhome.register.configuracao.exception.ConflictException;
import br.com.yourhome.register.configuracao.exception.ResourceNotFoundException;
import br.com.yourhome.register.usuario.Usuario;
import br.com.yourhome.register.usuario.UsuarioCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static br.com.yourhome.register.configuracao.ObjectHelper.copyNonNullProperties;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class CorretorCommand {

    private final CidadeQuery cidadeQuery;

    private final BairroQuery bairroQuery;

    private final UsuarioCommand usuarioCommand;

    private final CorretorProducer corretorProducer;

    private final CorretorRepository corretorRepository;

    private final MessageSourceHelper messageSourceHelper;

    public Corretor salvar(Corretor corretor) {
        corretorRepository.findCorretorByCreci(corretor.getCreci()).ifPresent(existente -> {
            throw new ConflictException(messageSourceHelper.getMessage("corretor.conflito", corretor.getCreci()));
        });
        Usuario usuario = usuarioCommand.salvar(corretor.getUsuario());
        Corretor novoCorretor = corretorRepository.save(corretor.withUsuario(usuario));
        corretorProducer.output(CorretorCadastradoMessage.of(novoCorretor, extrairCidades(novoCorretor), extrairBairros(novoCorretor)));
        return novoCorretor;
    }

    public Corretor atualizar(String documento, Corretor corretor) {
        Corretor corretorDb = findOne(documento);
        copyNonNullProperties(corretor, corretorDb);
        return corretorRepository.save(corretor);
    }

    private List<String> extrairCidades(Corretor corretor) {
        List<String> cidadesNomes = new ArrayList<>();
        corretor.getCidades().stream().forEach(cidade ->
                cidadesNomes.add(cidadeQuery.findById(cidade.getCidadeFk()).getNome()));
        return cidadesNomes;
    }

    private List<String> extrairBairros(Corretor corretor) {
        List<String> bairrosNomes = new ArrayList<>();
        corretor.getCidadesBairros().stream().forEach(bairro ->
                bairrosNomes.add(bairroQuery.findById(bairro.getBairroFk()).getNome()));
        return bairrosNomes;
    }

    private Corretor findOne(String documento) {
        return corretorRepository.findById(documento).orElseThrow(() -> new ResourceNotFoundException(messageSourceHelper.getMessage("corretor.nao.encontrado", documento)));
    }

}
