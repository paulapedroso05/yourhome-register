package br.com.yourhome.register.cidade.web;

import br.com.yourhome.register.cidade.Cidade;
import br.com.yourhome.register.cidade.CidadeQuery;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/cidades")
public class CidadeRestController {

    private final CidadeQuery cidadeQuery;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<Cidade> listar(
            @PageableDefault @SortDefault.SortDefaults({
                    @SortDefault(sort = "nome", direction = Sort.Direction.ASC) }) Pageable pageable) {
        return cidadeQuery.findAll(pageable);
    }

    @GetMapping("/{codigoIbge}")
    @ResponseStatus(HttpStatus.OK)
    EntityModel<Cidade> buscar(@PathVariable String codigoIbge){
        return EntityModel.of(cidadeQuery.findOne(codigoIbge));
    }

}
