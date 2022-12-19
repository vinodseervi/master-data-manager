package com.vi.controllers;

import com.sun.net.httpserver.Authenticator;
import com.vi.common.Constants;
import com.vi.models.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.vi.common.Constants.FAILED;

@RestController
@RequestMapping("/v1/healthcheck")
@Slf4j
public class HealthCheckController {

    private static String orgKey = "asdabdjashdgadgy12345";
    private static String appName = "MASTER_DATA_MANAGER";

    @GetMapping("/{key}")
    public ResponseEntity<Response> getHealthStatus(@PathVariable("key") String key ){
        log.info("KEy : {}", key);
        if(orgKey.equalsIgnoreCase(key)) {
            Response response = new Response();
            response.setStatus(Constants.SUCCESS);
            response.setPayload(Boolean.TRUE);
            log.info("Health Check Success : app id : {}",appName);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        return new ResponseEntity<>(Response.builder().status(FAILED).payload("").build(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
