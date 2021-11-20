package com.jwnming.dao;


import com.jwnming.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    int addUser(User user);

    User getUserById(Integer id);

    List<User> getAllUser();

}
