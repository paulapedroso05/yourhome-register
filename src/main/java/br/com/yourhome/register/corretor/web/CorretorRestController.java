package br.com.yourhome.register.corretor.web;

import br.com.yourhome.register.corretor.Corretor;
import br.com.yourhome.register.corretor.CorretorCommand;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/corretores")
public class CorretorRestController {

    private final CorretorCommand corretorCommand;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    EntityModel<Corretor> criar(@RequestBody @Valid Corretor corretor) {
        return EntityModel.of(corretorCommand.salvar(corretor));
    }

    @PutMapping("/{documento}")
    @ResponseStatus(HttpStatus.OK)
    EntityModel<Corretor> atualizar(@PathVariable String documento, @RequestBody @Valid Corretor corretor) {
        return EntityModel.of(corretorCommand.atualizar(documento, corretor));
    }

}
