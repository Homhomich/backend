package ru.relex.tastyfasty.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ru.relex.commons.model.CurrentUser;
import ru.relex.tastyfasty.security.model.LoginFailModel;
import ru.relex.tastyfasty.security.model.LoginSuccessModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class TastyFastyUnauthorizedEntryPoint implements AuthenticationEntryPoint {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        if (response.getStatus() != HttpServletResponse.SC_FORBIDDEN) {
//          response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().print(OBJECT_MAPPER.writeValueAsString(new LoginFailModel()));
        }
    }
}

