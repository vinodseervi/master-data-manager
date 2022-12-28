package com.vi.processors;

import com.vi.models.User;

import java.util.List;

public interface UserProcessor {

    List<User> getAllUsers() throws Exception;
    User getUserByUserId(String userId);

}
