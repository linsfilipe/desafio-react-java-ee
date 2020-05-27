package com.github.linsfilipe.repositories.impl;

import com.github.linsfilipe.domains.models.Profile;
import com.github.linsfilipe.repositories.IProfileRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ProfileRepositoryImpl implements IProfileRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public Profile save(Profile profile) {
        entityManager.persist(profile);
        return profile;
    }

    @Override
    public Profile update(Profile profile) {
        return entityManager.merge(profile);
    }

    @Override
    public List<Profile> findAll() {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Profile> criteria = builder.createQuery(Profile.class);
        criteria.from(Profile.class);

        return this.entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public Profile findById(Integer id) {
        return entityManager.find(Profile.class, id);
    }

    @Override
    public Profile delete(Integer id) {
        final Profile profile = findById(id);
        entityManager.remove(profile);
        return profile;
    }
}
