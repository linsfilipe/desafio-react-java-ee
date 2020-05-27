package com.github.linsfilipe.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.github.linsfilipe.domains.models.User;
import com.github.linsfilipe.repositories.IUserRepository;

public class UserRepositoryImpl implements IUserRepository {

	@Inject
    private EntityManager entityManager;
    
    @Override
    public User save(User user) {
        this.entityManager.persist(user);
        return user;
    }

    @Override
    public User update(User user) {
    	this.entityManager.merge(user);
    	return user;
    }

    @Override
    public User findById(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User findByNome(String nome) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);

        criteria.select(root).where(builder.equal(root.get("nome"), nome));

        return entityManager.createQuery(criteria).getSingleResult();
    }
    
    @Override
    public User findByLoginSenha(String login, String senha) {
    	try {
    		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    		CriteriaQuery<User> criteria = builder.createQuery(User.class);
    		Root<User> root = criteria.from(User.class);
    		
    		List<Predicate> predicates= new ArrayList<>();
    		predicates.add(builder.equal(root.get("login"), login));
    		predicates.add(builder.equal(root.get("senha"), senha));
    		
    		criteria.select(criteria.getSelection()).where(predicates.toArray(new Predicate[]{}));
    		TypedQuery<User> query = entityManager.createQuery(criteria);
    		
    		return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
    }

    @Override
    public User findByLogin(String login) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);

        criteria.select(root).where(builder.equal(root.get("login"), login));

        return entityManager.createQuery(criteria).getSingleResult();
    }

    @Override
    public User delete(Integer id) {
        final User user = findById(id);
        entityManager.remove(user);
        return user;
    }

    @Override
    public User delete(User user) {
        entityManager.remove(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        criteria.from(User.class);

        return this.entityManager.createQuery(criteria).getResultList();
    }

}
