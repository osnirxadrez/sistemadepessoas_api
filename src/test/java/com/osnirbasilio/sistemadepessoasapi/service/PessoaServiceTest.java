package com.osnirbasilio.sistemadepessoasapi.service;

import com.osnirbasilio.sistemadepessoasapi.dto.request.PessoaDTO;
import com.osnirbasilio.sistemadepessoasapi.dto.response.MensagemRespostaDTO;
import com.osnirbasilio.sistemadepessoasapi.entity.Pessoa;
import com.osnirbasilio.sistemadepessoasapi.repository.RepositorioPessoa;
import com.osnirbasilio.sistemadepessoasapi.utils.PessoaUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.osnirbasilio.sistemadepessoasapi.utils.PessoaUtils.criaFalsaEntidade;
import static com.osnirbasilio.sistemadepessoasapi.utils.PessoaUtils.criaFalsoDTO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    @Mock
    private RepositorioPessoa repositorioPessoa;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    void testDadoPessoaDTOEntaoRetornaMensagemSalvo(){
        PessoaDTO pessoaDTO = criaFalsoDTO();
        Pessoa pessoaEsperoSalvar = criaFalsaEntidade();

        when(repositorioPessoa.save(any(Pessoa.class))).thenReturn(pessoaEsperoSalvar);

        MensagemRespostaDTO mensagemDeSucessoEsperada = mensagemRespostaEsperada(pessoaEsperoSalvar.getId());

        MensagemRespostaDTO sucessoMensagem = pessoaService.criaPessoa(pessoaDTO);

        assertEquals(mensagemDeSucessoEsperada, sucessoMensagem);
    }

    private MensagemRespostaDTO mensagemRespostaEsperada(long id) {
        return MensagemRespostaDTO
                .builder()
                .mensagem("Criado pessoa com ID " + id)
                .build();
    }

}
