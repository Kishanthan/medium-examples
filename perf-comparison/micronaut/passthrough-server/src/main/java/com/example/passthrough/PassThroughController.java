package com.example.passthrough;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Maybe;

import javax.inject.Inject;

@Controller
public class PassThroughController {

    @Client("http://localhost:8688")
    @Inject
    RxHttpClient httpClient;

    @Post(value = "/passthrough")
    public Maybe passThrough(@Body HelloReq helloReq) {
        return httpClient.retrieve(HttpRequest.POST("/backend", helloReq)).firstElement();
    }
}
