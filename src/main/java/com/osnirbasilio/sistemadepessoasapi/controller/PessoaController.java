package com.osnirbasilio.sistemadepessoasapi.controller;

import com.osnirbasilio.sistemadepessoasapi.dto.MensagemRespostaDTO;
import com.osnirbasilio.sistemadepessoasapi.entity.Pessoa;
import com.osnirbasilio.sistemadepessoasapi.repository.RepositorioPessoa;
import com.osnirbasilio.sistemadepessoasapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaController {

    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MensagemRespostaDTO criaPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.criaPessoa(pessoa);
    }
}
