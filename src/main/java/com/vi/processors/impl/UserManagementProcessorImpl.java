package com.vi.processors.impl;

import com.vi.models.User;
import com.vi.processors.UserProcessor;
import com.vi.service.UserManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
public class UserManagementProcessorImpl implements UserProcessor {

    @Autowired
    private UserManagementService userManagementService;
    @Override
    public List<User> getAllUsers() throws Exception {
       // try {
       //     log.info("USER API SUCCESS");
       //     throw new Exception();
        return userManagementService.getAllUsers();



    }

    @Override
    public User getUserByUserId(String userId) {
        return null;
    }
}
