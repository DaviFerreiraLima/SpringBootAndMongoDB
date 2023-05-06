package com.example.mongomaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.mongomaven.repository")
@ComponentScan("com.example.*")
public class MongoMavenApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoMavenApplication.class, args);
    }

}
