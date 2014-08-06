package com.ps.guestbook.service.impl;

import com.ps.guestbook.entity.User;
import com.ps.guestbook.repository.UserRepository;
import com.ps.guestbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userRepository.delete(id);
    }

    @Override
    @Transactional
    public User getByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    @Transactional
    public User editUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
