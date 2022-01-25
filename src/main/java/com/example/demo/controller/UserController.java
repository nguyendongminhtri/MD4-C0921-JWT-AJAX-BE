package com.example.demo.controller;

import com.example.demo.dto.response.ResponseMessage;
import com.example.demo.model.Users;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        Optional<Users> users = userService.findById(id);
        if(!users.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.deleteById(users.get().getId());
        return new ResponseEntity<>(new ResponseMessage("Delete Success!"), HttpStatus.OK);
    }
}
