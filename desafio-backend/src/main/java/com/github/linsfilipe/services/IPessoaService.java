package com.github.linsfilipe.services;

import java.util.List;

import com.github.linsfilipe.domains.models.Pessoa;

public interface IPessoaService {

    Pessoa save(Pessoa pesssoa);

    Pessoa update(Pessoa pesssoa);

    Pessoa delete(Integer id);

    Pessoa delete(Pessoa user);

    List<Pessoa> findAll();

    Pessoa findById(Integer id);

}
