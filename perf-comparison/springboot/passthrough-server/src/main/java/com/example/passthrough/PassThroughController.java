package com.example.passthrough;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PassThroughController {

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/passthrough", method = RequestMethod.POST)
    public ResponseEntity<HelloReq> passThrough(@RequestBody HelloReq helloReq) {
        return restTemplate.postForEntity("http://localhost:8688/backend", helloReq, HelloReq.class);
    }

}
