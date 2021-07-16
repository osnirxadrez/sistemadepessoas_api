package com.osnirbasilio.sistemadepessoasapi.repository;

import com.osnirbasilio.sistemadepessoasapi.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioPessoa extends JpaRepository<Pessoa, Long> {
}
