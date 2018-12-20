package com.example.hello;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/hello")
    public ResponseEntity<String> hello() {
        return restTemplate.getForEntity("http://localhost:8080/HelloApp/webapi/hello/spring", String.class);
    }

}
