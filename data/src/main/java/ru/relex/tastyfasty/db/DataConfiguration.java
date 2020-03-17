package ru.relex.tastyfasty.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("ru.relex.tastyfasty.db.mapper")
public class DataConfiguration {
}
