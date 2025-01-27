package br.com.yourhome.register.bairro.web;

import br.com.yourhome.register.bairro.Bairro;
import br.com.yourhome.register.bairro.BairroQuery;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/bairros/{codigoIbge}")
public class BairroRestController {

    private final BairroQuery bairroQuery;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<Bairro> listar(@PathVariable String codigoIbge,
            @PageableDefault @SortDefault.SortDefaults({
                    @SortDefault(sort = "nome", direction = Sort.Direction.ASC) }) Pageable pageable) {
        return bairroQuery.findAll(codigoIbge, pageable);
    }

}
