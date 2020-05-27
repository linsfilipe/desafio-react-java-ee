package com.github.linsfilipe.repositories;

import java.util.List;

import com.github.linsfilipe.domains.models.Pessoa;

public interface IPessoaRepository {

    Pessoa save(Pessoa pessoa);

    Pessoa update(Pessoa pessoa);

    Pessoa findById(Integer id);

    Pessoa delete(Integer id);

    Pessoa delete(Pessoa pessoa);

    List<Pessoa> findAll();

}
