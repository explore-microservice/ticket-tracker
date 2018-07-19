package com.issuetracker.webapp.configuration;

import com.issuetracker.webapp.service.MessageProviderServiceImpl;
import com.issuetracker.webapp.service.MessageProviderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MessageProviderService messageProvider(){
        return new MessageProviderServiceImpl();
    }
}
