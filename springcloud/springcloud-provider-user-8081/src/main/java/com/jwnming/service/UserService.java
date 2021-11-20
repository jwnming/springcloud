package com.jwnming.service;

import com.jwnming.entity.User;

import java.util.List;

public interface UserService {

    boolean addUser(User user);

    User getUserById(Integer id);

    List<User> getAllUser();

}
