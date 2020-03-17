package ru.relex.tastyfasty.services;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.relex.tastyfasty.db.DataConfiguration;

@Configuration
@Import(DataConfiguration.class)
public class ServicesConfiguration {
}
