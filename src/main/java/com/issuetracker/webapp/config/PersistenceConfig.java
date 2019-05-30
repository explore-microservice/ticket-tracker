package com.issuetracker.webapp.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.issuetracker.webapp.repository")
public interface PersistenceConfig {
}
