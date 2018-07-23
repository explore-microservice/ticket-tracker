package com.issuetracker.webapp.controller;

import com.issuetracker.webapp.service.MessageProviderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController{

    private final MessageProviderService messageProvider;

    public GreetingController(MessageProviderService messageProvider) {
        this.messageProvider = messageProvider;
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return messageProvider.getMessage(name);
    }
}
