package com.example.starter.controller;

import com.example.starter.model.User;
import com.example.starter.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUserList(){
        return userService.listUsers();
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user){ //here we are stating that we will receive the user from the request body
        userService.addUser(user);
        return user.getName()+" added to the db successfully";
    }

    @GetMapping
    public User getUser(@RequestParam String name){
        return userService.findByName(name);
    }

    @PutMapping("/update/{oldName}")
    public String updateUserName(@PathVariable String oldName, @RequestBody User user){
        return userService.updateName(oldName, user);
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam String name){
        return userService.deleteUser(name);
    }
}
