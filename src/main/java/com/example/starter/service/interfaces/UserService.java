package com.example.starter.service.interfaces;

import com.example.starter.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    String addUser(User user);
    User findByName(String name);
    String updateName(String oldName, User user);
    String deleteUser(String name);
}
