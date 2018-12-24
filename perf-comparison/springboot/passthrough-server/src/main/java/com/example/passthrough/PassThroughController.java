package com.example.passthrough;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PassThroughController {

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/passthrough")
    public ResponseEntity<String> hello() {
        return restTemplate.getForEntity("http://localhost:8686/backend", String.class);
    }

}
