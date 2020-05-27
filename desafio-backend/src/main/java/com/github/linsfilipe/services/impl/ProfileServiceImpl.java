package com.github.linsfilipe.services.impl;

import static javax.ejb.TransactionAttributeType.REQUIRED;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import com.github.linsfilipe.domains.models.Profile;
import com.github.linsfilipe.repositories.IProfileRepository;
import com.github.linsfilipe.services.IProfileService;

@TransactionAttribute(REQUIRED)
public class ProfileServiceImpl implements IProfileService {

    @Inject
    private IProfileRepository profileRepository;

    @Override
    @TransactionAttribute(REQUIRED)
    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    @TransactionAttribute(REQUIRED)
    public Profile update(Profile profile) {
        return profileRepository.update(profile);
    }

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile findById(Integer id) {
        return profileRepository.findById(id);
    }

    @Override
    @TransactionAttribute(REQUIRED)
    public Profile delete(Integer id) {
        return profileRepository.delete(id);
    }
}
