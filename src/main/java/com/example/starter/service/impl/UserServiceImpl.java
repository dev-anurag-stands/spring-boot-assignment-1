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
        if(user == null || user.getName() == "" || user.getAge() <= 0 || user.getEmail() == ""){
            throw new IllegalArgumentException("Invalid user");
        }
        userRepository.save(user);
        return "user "+ user.getName() + "added successfully ";
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public String updateName(String oldName, User user){
       User user1 = userRepository.findByName(oldName);
       if(user.getName()!=null)user1.setName(user.getName());
       user1.setAge(user.getAge());
       userRepository.save(user1);
       return "user updated successfully";
    }

    @Override
    public String deleteUser(String name) {
        userRepository.deleteByName(name);
        return "user deleted successfully";
    }
}
