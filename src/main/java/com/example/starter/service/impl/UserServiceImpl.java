package com.example.starter.service.impl;

import com.example.starter.model.User;
import com.example.starter.repository.UserRepository;
import com.example.starter.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //telling that it will contain all the business logic of our application (about the user)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listUsers(){
        return userRepository.findAll();
    }

    @Override
    public String addUser(User user){
        userRepository.save(user);
        return "user "+ user.getName() + "added successfully ";
    }
}
