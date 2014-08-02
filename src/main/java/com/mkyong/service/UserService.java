package com.mkyong.service;

import com.mkyong.entity.User;

import java.util.List;

public interface UserService {

    public User add(User user);

    public void delete(long id);

    public User getByName(String name);

    public User editUser(User user);

    public List<User> getAll();
}
