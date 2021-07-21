package com.osnirbasilio.sistemadepessoasapi.service;

import com.osnirbasilio.sistemadepessoasapi.dto.request.PessoaDTO;
import com.osnirbasilio.sistemadepessoasapi.dto.response.MensagemRespostaDTO;
import com.osnirbasilio.sistemadepessoasapi.entity.Pessoa;
import com.osnirbasilio.sistemadepessoasapi.mapper.PessoaMapper;
import com.osnirbasilio.sistemadepessoasapi.repository.RepositorioPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private RepositorioPessoa repositorioPessoa;

    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    @Autowired
    public PessoaService(RepositorioPessoa repositorioPessoa){
        this.repositorioPessoa = repositorioPessoa;
    }

    public MensagemRespostaDTO criaPessoa(PessoaDTO pessoaDTO){
        Pessoa pessoaParaSalvar = pessoaMapper.toModel(pessoaDTO);

        Pessoa pessoaSalva = repositorioPessoa.save(pessoaParaSalvar);
        return MensagemRespostaDTO
                .builder()
                .mensagem("Criado pessoa com ID " + pessoaSalva.getId())
                .build();
    }

    public List<PessoaDTO> listarTodos() {
       List<Pessoa> todasPessoas = repositorioPessoa.findAll();
       return todasPessoas.stream()
               .map(pessoaMapper::toDTO)
               .collect(Collectors.toList());
    }
}
