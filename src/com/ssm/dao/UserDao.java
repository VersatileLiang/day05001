package com.ssm.dao;

import java.util.List;
import java.util.Map;

import com.ssm.entity.User;

public interface UserDao {

    List<User> getAllUser();

    User findUser(Map<String, Object> map);

    void deleteUser(String userid);

    List<User> searchUsers(String username);

    void updateUsers(String username, String password);
}
