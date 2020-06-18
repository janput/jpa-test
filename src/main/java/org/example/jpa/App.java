package org.example.jpa;

import org.example.jpa.persistence.AuditedRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = AuditedRepositoryImpl.class)
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
