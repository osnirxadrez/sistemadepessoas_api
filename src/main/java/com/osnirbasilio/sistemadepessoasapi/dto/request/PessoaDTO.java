package com.osnirbasilio.sistemadepessoasapi.dto.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String primeiroNome;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String ultimoNome;

    @NotEmpty
    @CPF
    private String cpf;

    private String dataNascimento;

    @Valid
    @NotEmpty
    private List<TelefoneDTO> telefones;

}
