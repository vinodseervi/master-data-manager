package com.vi.controllers;

import com.vi.entity.UserDto;
import com.vi.models.UserRequest;
import com.vi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public List<UserDto> getallUsers(){
    }



}
