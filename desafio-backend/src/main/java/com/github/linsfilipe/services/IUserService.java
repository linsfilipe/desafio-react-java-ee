package com.github.linsfilipe.services;

import com.github.linsfilipe.domains.models.User;

import java.util.List;

public interface IUserService {

    User save(User user);

    User update(User user);

    User findById(Integer id);

    User findByNome(String nome);

    User findByLogin(String login);

    User findByLoginSenha(String login, String senha);

    User delete(Integer id);

    User delete(User user);

    List<User> findAll();

}
