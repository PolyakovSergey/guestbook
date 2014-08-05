package com.ps.guestbook.service.impl;

import com.ps.guestbook.entity.User;
import com.ps.guestbook.repository.UserRepository;
import com.ps.guestbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }

    @Override
    public User getByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User editUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
