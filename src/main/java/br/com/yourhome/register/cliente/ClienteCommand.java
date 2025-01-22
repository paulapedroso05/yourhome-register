package br.com.yourhome.register.cliente;

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
public class ClienteCommand {

    private final ClienteRepository clienteRepository;

    private final MessageSourceHelper messageSourceHelper;

    public Cliente salvar(Cliente cliente) {
        clienteRepository.findById(cliente.getDocumento()).ifPresent(existente -> {
            throw new ConflictException(messageSourceHelper.getMessage("cliente.conflito", cliente.getDocumento()));
        });
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(String documento, Cliente cliente) {
        Cliente clienteDb = findOne(documento);
        copyNonNullProperties(cliente, clienteDb);
        return clienteRepository.save(cliente);
    }

    private Cliente findOne(String documento) {
        return clienteRepository.findById(documento).orElseThrow(() -> new ResourceNotFoundException(messageSourceHelper.getMessage("cliente.nao.encontrado", documento)));
    }

}
