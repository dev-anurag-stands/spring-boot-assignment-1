package com.example.starter.controller;

import com.example.starter.model.User;
import com.example.starter.service.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUserList(){
        return new ResponseEntity<List<User>>(userService.listUsers(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@Valid @RequestBody User user){ //here we are stating that we will receive the user from the request body
        userService.addUser(user);
        return new ResponseEntity<>(user.getName()+" added successfully",HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<User> getUser(@RequestParam String name){
        User user = userService.findByName(name);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/update/{oldName}")
    public ResponseEntity<String> updateUser(@PathVariable String oldName, @RequestBody User user){
        if(userService.findByName(oldName) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.updateName(oldName, user), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam String name){
        if(userService.findByName(name) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.deleteUser(name), HttpStatus.OK);
    }
}
