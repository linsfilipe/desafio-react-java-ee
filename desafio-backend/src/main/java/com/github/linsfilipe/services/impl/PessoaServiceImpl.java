package com.github.linsfilipe.services.impl;

import static javax.ejb.TransactionAttributeType.REQUIRED;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import com.github.linsfilipe.domains.models.Pessoa;
import com.github.linsfilipe.repositories.impl.PessoaRepository;
import com.github.linsfilipe.services.IPessoaService;

@Stateless
@TransactionAttribute(REQUIRED)
public class PessoaServiceImpl implements IPessoaService {

    @Inject
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
    
    @Override
    public Pessoa update(Pessoa pessoa) {
    	return pessoaRepository.update(pessoa);
    }

    @Override
    public Pessoa findById(Integer id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public Pessoa delete(Integer id) {
        return pessoaRepository.delete(id);
    }

    @Override
    public Pessoa delete(Pessoa pessoa) {
        return pessoaRepository.delete(pessoa);
    }

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }
}
