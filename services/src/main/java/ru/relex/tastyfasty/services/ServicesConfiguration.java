package ru.relex.tastyfasty.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.relex.tastyfasty.db.DataConfiguration;

@Configuration
@ComponentScan({"ru.relex.tastyfasty.services.mapstruct", "ru.relex.tastyfasty.services.service"})
@Import(DataConfiguration.class)
public class ServicesConfiguration {
}
