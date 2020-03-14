package ru.relex.tastyfasty.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.relex.tastyfasty.db.DataConfiguration;

@SpringBootApplication(
        scanBasePackages = "ru.relex.tastyfasty.rest"
)
@Import(DataConfiguration.class)
public class TastyFasty {
    public static void main(String[] args) {
        SpringApplication.run(TastyFasty.class, args);
    }
}
