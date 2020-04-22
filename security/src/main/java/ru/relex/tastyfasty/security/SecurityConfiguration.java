package ru.relex.tastyfasty.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.relex.tastyfasty.security.handler.TastyFastyFailHandler;
import ru.relex.tastyfasty.security.handler.TastyFastyUnauthorizedEntryPoint;
import ru.relex.tastyfasty.security.handler.TastyFastyLogoutSuccessHandler;
import ru.relex.tastyfasty.security.handler.TastyFastySuccessHandler;

@Configuration
@EnableWebSecurity
@Import(CurrentUserConfiguration.class)
@ComponentScan({
        "ru.relex.tastyfasty.security.service",
        "ru.relex.tastyfasty.security.handler"
})
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final TastyFastySuccessHandler successHandler;
    private final TastyFastyLogoutSuccessHandler logoutSuccessHandler;
    private final TastyFastyFailHandler failHandler;
    private final TastyFastyUnauthorizedEntryPoint unauthorizedEntryPoint;

    @Autowired
    public SecurityConfiguration(
            UserDetailsService userDetailsService,
            TastyFastySuccessHandler successHandler,
            TastyFastyLogoutSuccessHandler logoutSuccessHandler,
            TastyFastyFailHandler failHandler,
            TastyFastyUnauthorizedEntryPoint unauthorizedEntryPoint
    ) {
        this.userDetailsService = userDetailsService;
        this.successHandler = successHandler;
        this.logoutSuccessHandler = logoutSuccessHandler;
        this.failHandler = failHandler;
        this.unauthorizedEntryPoint = unauthorizedEntryPoint;
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) {
        final var daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        builder.authenticationProvider(daoAuthenticationProvider);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/restaurants", "/api/restaurants/*", "/api/restaurants/*/breakfasts").permitAll()
                .antMatchers("/api/auth/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .cors()
                .and()
                .formLogin()
                .loginProcessingUrl("/api/auth/login")
                .successHandler(successHandler)
                .failureHandler(failHandler)
                .and()
                .logout()
                .logoutUrl("/api/auth/logout")
                .logoutSuccessHandler(logoutSuccessHandler)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedEntryPoint)
                .and()
                .sessionManagement()
                .sessionFixation()
                .changeSessionId();

    }
}
