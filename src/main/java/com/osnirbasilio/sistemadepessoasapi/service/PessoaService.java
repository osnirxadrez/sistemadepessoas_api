package com.osnirbasilio.sistemadepessoasapi.service;

import com.osnirbasilio.sistemadepessoasapi.dto.request.PessoaDTO;
import com.osnirbasilio.sistemadepessoasapi.dto.response.MensagemRespostaDTO;
import com.osnirbasilio.sistemadepessoasapi.entity.Pessoa;
import com.osnirbasilio.sistemadepessoasapi.exception.PessoaNaoEncontradaException;
import com.osnirbasilio.sistemadepessoasapi.mapper.PessoaMapper;
import com.osnirbasilio.sistemadepessoasapi.repository.RepositorioPessoa;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {

    private RepositorioPessoa repositorioPessoa;

    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    public MensagemRespostaDTO criaPessoa(PessoaDTO pessoaDTO){
        Pessoa pessoaParaSalvar = pessoaMapper.toModel(pessoaDTO);

        Pessoa pessoaSalva = repositorioPessoa.save(pessoaParaSalvar);
        return criaMensagemResposta(pessoaSalva.getId(), "Criado pessoa com ID ");
    }

    public List<PessoaDTO> listarTodos() {
       List<Pessoa> todasPessoas = repositorioPessoa.findAll();
       return todasPessoas.stream()
               .map(pessoaMapper::toDTO)
               .collect(Collectors.toList());
    }

    public PessoaDTO pesquisaPorId(Long id) throws PessoaNaoEncontradaException {
       Pessoa pessoa = verificaSeExiste(id);

        /*
        Optional<Pessoa> pessoaOpcional = repositorioPessoa.findById(id);
        if (pessoaOpcional.isEmpty()){
            throw new PessoaNaoEncontradaException(id);
        }*/

        return pessoaMapper.toDTO(pessoa);
    }

    public void deletar(Long id) throws PessoaNaoEncontradaException {
        verificaSeExiste(id);

        repositorioPessoa.deleteById(id);
    }

    public MensagemRespostaDTO atualizarPorId(Long id, PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException {
        verificaSeExiste(id);
        Pessoa pessoaParaAtualizar = pessoaMapper.toModel(pessoaDTO);

        Pessoa pessoaAtualizada = repositorioPessoa.save(pessoaParaAtualizar);
        return criaMensagemResposta(pessoaAtualizada.getId(), "Pessoa atualizada com ID ");
    }

    private MensagemRespostaDTO criaMensagemResposta(Long id, String mensagem) {
        return MensagemRespostaDTO
                .builder()
                .mensagem(mensagem + id)
                .build();
    }

    private Pessoa verificaSeExiste(Long id) throws PessoaNaoEncontradaException{
        return repositorioPessoa.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException(id));
    }
}
