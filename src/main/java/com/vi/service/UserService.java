package com.vi.service;


import com.vi.models.UserRequest;

import java.util.List;

public class UserService {
    List<UserRequest> getAllUsers() {
        return null;
    }



//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//
//    public List<UserDto> getAllUser(){
//        return userRepository.findAll()
//                .stream()
//                .map(this::convertModelToEntity)
//                .collect(Collectors.toList());
//    }
//
//    private UserDto convertModelToEntity(){
//        UserDto user = new UserDto();
//        user.setUserId(userRequest.getUserId());
//        user.setFirstName(user.getFirstName());
//        user.setLastName(userRequest.getLastName());
//        user.setEmailId(userRequest.getEmailId());
//        user.setPassword(userRequest.getPassword());
//        user.setDob(userRequest.setDob());
//        return user;
//
//
//    }

}
