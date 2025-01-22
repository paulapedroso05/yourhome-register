package br.com.yourhome.register.cliente.web;

import br.com.yourhome.register.cliente.Cliente;
import br.com.yourhome.register.cliente.ClienteCommand;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/clientes")
public class ClienteRestController {

    private final ClienteCommand clienteCommand;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    EntityModel<Cliente> criar(@RequestBody @Valid Cliente cliente) {
        return EntityModel.of(clienteCommand.salvar(cliente));
    }

    @PutMapping("/{documento}")
    @ResponseStatus(HttpStatus.OK)
    EntityModel<Cliente> atualizar(@PathVariable String documento, @RequestBody @Valid Cliente cliente) {
        return EntityModel.of(clienteCommand.atualizar(documento, cliente));
    }

}
