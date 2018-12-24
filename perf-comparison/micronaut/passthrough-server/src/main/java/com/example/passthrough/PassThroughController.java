package com.example.passthrough;

import io.micronaut.core.io.buffer.ByteBuffer;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Inject;

@Controller
public class PassThroughController {

    @Client("http://localhost:8688")
    @Inject
    RxHttpClient httpClient;

    @Post(value = "/passthrough")
    public Flowable passThrough(@Body HelloReq helloReq) {
        return httpClient.retrieve(HttpRequest.POST("/backend", helloReq));
    }
}
