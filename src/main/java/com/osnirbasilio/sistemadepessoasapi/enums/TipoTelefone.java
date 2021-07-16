package com.osnirbasilio.sistemadepessoasapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {

    CASA("Casa"),
    MOVEL("Movel"),
    COMERCIAL("Comercial");

    private final String descricao;
}
