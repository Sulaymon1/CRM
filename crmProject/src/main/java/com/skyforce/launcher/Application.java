package com.skyforce.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Sulaymon on 11.03.2018.
 */
@SpringBootApplication
@ComponentScan("com.skyforce")
@EntityScan(basePackages = "com.skyforce.models")
@EnableJpaRepositories(basePackages = "com.skyforce.repositories")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
