package com.example.passthrough;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import org.reactivestreams.Publisher;

import javax.inject.Inject;

@Controller
public class PassThroughController {

    @Client("http://localhost:8080/backend")
    @Inject
    HttpClient httpClient;

    @Get(value = "/passthrough")
    public Publisher<String> passThrough() {
        return httpClient.retrieve("/micronaut");
    }
}
