package com.vi.controllers;

import com.vi.processors.UserProcessor;
import com.vi.response.Response;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.vi.common.Constants.SUCCESS;

@RestController
@RequestMapping("/v1/user")
@Slf4j
public class UserManagementController {


    @Autowired
    private UserProcessor userProcessor;

    @GetMapping("/all")
    public ResponseEntity<Response> getAllUsers() throws Exception {
        log.info("GET ALL USER REQUEST RECIEVED");
        Response response = new Response();
        response.setStatus(SUCCESS);
        response.setPayload(userProcessor.getAllUsers());
        log.info("GET ALL SUCCESS : USERS FETCHED {}",response.getPayload());
        return ResponseEntity.ok(response);
    }


}
