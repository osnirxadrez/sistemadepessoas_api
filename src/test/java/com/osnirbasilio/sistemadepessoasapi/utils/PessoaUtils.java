package com.osnirbasilio.sistemadepessoasapi.utils;

import com.osnirbasilio.sistemadepessoasapi.dto.request.PessoaDTO;
import com.osnirbasilio.sistemadepessoasapi.entity.Pessoa;

import java.time.LocalDate;
import java.util.Collections;

public class PessoaUtils {

    private static final String PRIMEIRO_NOME = "Osnir";
    private static final String ULTIMO_NOME = "Basilio";
    private static final String CPF_NUMERO = "103.568.189-77";
    private static final long  PESSOA_ID = 1L;
    private static final LocalDate DATA_NASCIMENTO = LocalDate.of(1998, 6, 16);

    public static PessoaDTO criaFalsoDTO() {
        return PessoaDTO.builder()
                .primeiroNome(PRIMEIRO_NOME)
                .ultimoNome(ULTIMO_NOME)
                .cpf(CPF_NUMERO)
                .dataNascimento("16-06-1998")
                .telefones(Collections.singletonList(TelefoneUtils.criaFalsoDTO()))
                .build();
    }

    public static Pessoa criaFalsaEntidade() {
        return Pessoa.builder()
                .id(PESSOA_ID)
                .primeiroNome(PRIMEIRO_NOME)
                .ultimoNome(ULTIMO_NOME)
                .cpf(CPF_NUMERO)
                .dataNascimento(DATA_NASCIMENTO)
                .telefones(Collections.singletonList(TelefoneUtils.criaFalsaEntidade()))
                .build();
    }
}
