package com.vi.controllers;



import com.vi.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@Slf4j
class HealthCheckControllerTest {

    @InjectMocks
    private HealthCheckController healthCheckController;

    private static final  String orgKey = "asdabdjashdgadgy12345";
    @BeforeEach
    public  void setUp(){
         healthCheckController = new HealthCheckController();
    }

    @Test
    public void testHealthCheckCOntroller() {

       ResponseEntity<Response> result = healthCheckController.getHealthStatus(orgKey);
       assertTrue(result.getStatusCode().is2xxSuccessful());
    }



}