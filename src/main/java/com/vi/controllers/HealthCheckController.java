package com.vi.controllers;

import com.vi.common.Constants;
import com.vi.exception.ResourceNotFoundException;
import com.vi.models.Employee;
import com.vi.models.HealthCheck;
import com.vi.repository.HealthCheckRepository;
import com.vi.response.Response;
import com.vi.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.vi.common.Constants.FAILED;
import static com.vi.common.Constants.SUCCESS;

@RestController
@RequestMapping("/v1/healthcheck")
@Slf4j
public class HealthCheckController {
    @Autowired
    private HealthCheckRepository healthCheckRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    private static String orgKey = "asdabdjashdgadgy12345";
    private static String appName = "MASTER_DATA_MANAGER";

    private static long fixedId = 2L;

    @GetMapping("app/{key}")
    public ResponseEntity<Response> getHealthStatus(@PathVariable("key") String key) {
        log.info("KEy : {}", key);
        if (orgKey.equalsIgnoreCase(key)) {
            Response response = new Response();
            response.setStatus(Constants.SUCCESS);
            response.setPayload(Boolean.TRUE);
            log.info("Health Check Success : app id : {}", appName);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(Response.builder().status(FAILED).payload("").build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping("db/{key}")
    public ResponseEntity<Response> getHealthCheckById(@PathVariable("key") String key) {
        HealthCheck healthCheck;
        Response response = new Response();
        try {
            if (!orgKey.equalsIgnoreCase(key)) {
                throw new Exception();
            }

            healthCheck = healthCheckRepository.findById(fixedId).orElseThrow(() -> new ResourceNotFoundException("FF: " + key));
            response.setPayload(healthCheck);
            response.setStatus(SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            response.setStatus(FAILED);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
