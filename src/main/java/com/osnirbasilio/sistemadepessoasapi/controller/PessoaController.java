package com.osnirbasilio.sistemadepessoasapi.controller;

import com.osnirbasilio.sistemadepessoasapi.dto.MensagemRespostaDTO;
import com.osnirbasilio.sistemadepessoasapi.entity.Pessoa;
import com.osnirbasilio.sistemadepessoasapi.repository.RepositorioPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaController {

    private RepositorioPessoa repositorioPessoa;

    @Autowired
    public PessoaController(RepositorioPessoa repositorioPessoa) {
        this.repositorioPessoa = repositorioPessoa;
    }

    @PostMapping
    public MensagemRespostaDTO criaPessoa(@RequestBody Pessoa pessoa){
        Pessoa pessoaSalva = repositorioPessoa.save(pessoa);
        return MensagemRespostaDTO.builder()
                .mensagem("Criado pessoa com ID" + pessoaSalva.getId())
                .build();
    }
}
