package com.mokachi.fullstack_backend_demo.controller;

import com.mokachi.fullstack_backend_demo.exception.UserNotFoundException;
import com.mokachi.fullstack_backend_demo.model.User;
import com.mokachi.fullstack_backend_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/newuser")
    private User newUser(@RequestBody User newuser){
        return userRepository.save(newuser);
    }

    @GetMapping("/users")
    private List<User> getusers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    private User getuser(@PathVariable long id){
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    private User updateuser(@RequestBody User newuser, @PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setEmail(newuser.getEmail());
                    user.setUsername(newuser.getUsername());
                    user.setName(newuser.getName());
                    return userRepository.save(user);
                }).orElseThrow(()-> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    private String deleteuser(@PathVariable long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id " + id + " has been deleted successfully";
    }

    //tent prices
    //size, material,
}
