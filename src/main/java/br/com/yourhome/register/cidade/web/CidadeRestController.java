package br.com.yourhome.register.cidade.web;

import br.com.yourhome.register.cidade.Cidade;
import br.com.yourhome.register.cidade.CidadeQuery;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

}
