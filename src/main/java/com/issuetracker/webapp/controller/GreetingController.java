package com.issuetracker.webapp.controller;

import com.issuetracker.webapp.configuration.AppConfig;
import com.issuetracker.webapp.service.MessageProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController{

    @Autowired
    private AppConfig appConfig;

    @RequestMapping("/greeting")
    public MessageProviderService greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return appConfig.messageProvider();
    }
}
