package com.hypermedia.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @GetMapping(value = "/echo")
    public String echoEndpoint() {
        return "Hello.Welcome to spring boot unit test.";
    }
}
