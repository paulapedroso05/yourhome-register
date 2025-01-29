package br.com.yourhome.register.usuario;

import br.com.yourhome.register.configuracao.MessageSourceHelper;
import br.com.yourhome.register.configuracao.exception.ConflictException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class UsuarioCommand {

    private final UsuarioRepository usuarioRepository;

    private final MessageSourceHelper messageSourceHelper;

    public Usuario salvar(Usuario usuario) {
        usuarioRepository.findUsuarioByCpf(usuario.getCpf()).ifPresent(existente -> {
            throw new ConflictException(messageSourceHelper.getMessage("corretor.conflito", usuario.getCpf()));
        });
        return usuarioRepository.save(usuario);
    }

}
