package com.jwnming.service.impl;

import com.jwnming.dao.UserDao;
import com.jwnming.entity.User;
import com.jwnming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    public boolean addUser(User user) {
        int i = userDao.addUser(user);
        return i == 1;
    }

    public User getUserById(Integer id) {
        User user = userDao.getUserById(id);
        return user;
    }

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
}
