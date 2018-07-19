package com.issuetracker.webapp.service;

import org.springframework.stereotype.Service;

@Service
public class MessageProviderServiceImpl implements MessageProviderService {

    private static final String template = "Hello, %s!";

    @Override
    public String getMessage(String name) {
        return String.format(template, name);
    }
}
