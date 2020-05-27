package com.github.linsfilipe.services.impl;

import static javax.ejb.TransactionAttributeType.REQUIRED;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import com.github.linsfilipe.domains.models.User;
import com.github.linsfilipe.repositories.IUserRepository;
import com.github.linsfilipe.services.IUserService;

@Stateless
@TransactionAttribute(REQUIRED)
public class UserServiceImpl implements IUserService {

    @Inject
    private IUserRepository userRepository;

    @Override
    @TransactionAttribute(REQUIRED)
    public User save(User user) {
        return userRepository.save(user);
    }
    
    @Override
    @TransactionAttribute(REQUIRED)
    public User update(User user) {
    	return userRepository.update(user);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByNome(String nome) {
        return userRepository.findByNome(nome);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
    
    @Override
    public User findByLoginSenha(String login, String senha) {
    	return userRepository.findByLoginSenha(login, senha);
    }

    @Override
    @TransactionAttribute(REQUIRED)
    public User delete(Integer id) {
        return userRepository.delete(id);
    }

    @Override
    @TransactionAttribute(REQUIRED)
    public User delete(User user) {
        return userRepository.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
