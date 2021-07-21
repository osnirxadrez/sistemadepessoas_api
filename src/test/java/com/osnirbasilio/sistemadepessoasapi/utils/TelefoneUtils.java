package com.osnirbasilio.sistemadepessoasapi.utils;

import com.osnirbasilio.sistemadepessoasapi.dto.request.TelefoneDTO;
import com.osnirbasilio.sistemadepessoasapi.entity.Telefone;
import com.osnirbasilio.sistemadepessoasapi.enums.TipoTelefone;

public class TelefoneUtils {

    private static final String NUMERO_TELEFONE = "4899102-1565";
    private static final TipoTelefone TIPO_TELEFONE = TipoTelefone.MOVEL;
    private static final long TELEFONE_ID = 1L;
    public static TelefoneDTO criaFalsoDTO() {
        return TelefoneDTO.builder()
                .numero(NUMERO_TELEFONE)
                .tipo(TIPO_TELEFONE)
                .build();
    }

    public static Telefone criaFalsaEntidade() {
        return Telefone.builder()
                .id(TELEFONE_ID)
                .numero(NUMERO_TELEFONE)
                .tipo(TIPO_TELEFONE)
                .build();
    }
}
