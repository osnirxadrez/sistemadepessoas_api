package com.osnirbasilio.sistemadepessoasapi.service;

import com.osnirbasilio.sistemadepessoasapi.dto.MensagemRespostaDTO;
import com.osnirbasilio.sistemadepessoasapi.entity.Pessoa;
import com.osnirbasilio.sistemadepessoasapi.repository.RepositorioPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PessoaService {

    private RepositorioPessoa repositorioPessoa;

    @Autowired
    public PessoaService(RepositorioPessoa repositorioPessoa){
        this.repositorioPessoa = repositorioPessoa;
    }

    public MensagemRespostaDTO criaPessoa(@RequestBody Pessoa pessoa){
        Pessoa pessoaSalva = repositorioPessoa.save(pessoa);
        return MensagemRespostaDTO.builder()
                .mensagem("Criado pessoa com ID " + pessoaSalva.getId())
                .build();
    }
}
