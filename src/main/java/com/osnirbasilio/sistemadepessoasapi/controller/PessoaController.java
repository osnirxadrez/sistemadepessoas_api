package com.osnirbasilio.sistemadepessoasapi.controller;

import com.osnirbasilio.sistemadepessoasapi.dto.request.PessoaDTO;
import com.osnirbasilio.sistemadepessoasapi.dto.response.MensagemRespostaDTO;
import com.osnirbasilio.sistemadepessoasapi.exception.PessoaNaoEncontradaException;
import com.osnirbasilio.sistemadepessoasapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public MensagemRespostaDTO criaPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return pessoaService.criaPessoa(pessoaDTO);
    }

    @GetMapping
    public List<PessoaDTO> listarTodos(){
        return  pessoaService.listarTodos();
    }

    @GetMapping("/{id}")
    public PessoaDTO pesquisaPorId(@PathVariable Long id) throws PessoaNaoEncontradaException {
        return pessoaService.pesquisaPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable Long id) throws PessoaNaoEncontradaException {
        pessoaService.deletar(id);
    }
}
