package com.github.linsfilipe.repositories.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.github.linsfilipe.domains.models.Pessoa;
import com.github.linsfilipe.repositories.IPessoaRepository;

public class PessoaRepository implements IPessoaRepository {

	@Inject
    private EntityManager entityManager;

	@Override
	public Pessoa save(Pessoa pessoa) {
		this.entityManager.persist(pessoa);
        return pessoa;
	}

	@Override
	public Pessoa update(Pessoa pessoa) {
		this.entityManager.merge(pessoa);
        return pessoa;
	}

	@Override
	public Pessoa findById(Integer id) {
		return entityManager.find(Pessoa.class, id);
	}

	@Override
	public Pessoa delete(Integer id) {
		final Pessoa pessoa = findById(id);
		this.entityManager.merge(pessoa);
		return pessoa;
	}

	@Override
	public Pessoa delete(Pessoa pessoa) {
		this.entityManager.remove(pessoa);
		return pessoa;
	}

	@Override
	public List<Pessoa> findAll() {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Pessoa> criteria = builder.createQuery(Pessoa.class);
        criteria.from(Pessoa.class);

        return this.entityManager.createQuery(criteria).getResultList();
	}
    


}
