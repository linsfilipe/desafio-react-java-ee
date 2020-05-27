package com.github.linsfilipe.services;

import com.github.linsfilipe.domains.models.Profile;

import java.util.List;

public interface IProfileService {

    Profile save(Profile profile);

    Profile update(Profile profile);

    List<Profile> findAll();

    Profile findById(Integer id);

    Profile delete(Integer id);

}
