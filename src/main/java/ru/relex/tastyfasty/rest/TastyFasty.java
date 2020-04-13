package ru.relex.tastyfasty.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.relex.tastyfasty.security.SecurityConfiguration;
import ru.relex.tastyfasty.services.ServicesConfiguration;

@SpringBootApplication(
        scanBasePackages = "ru.relex.tastyfasty.rest"
)
@Import({ServicesConfiguration.class,
        SecurityConfiguration.class})
public class  TastyFasty {
    public static void main(String[] args) {
        SpringApplication.run(TastyFasty.class, args);
    }

}
