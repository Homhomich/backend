package ru.relex.tastyfasty.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import ru.relex.tastyfasty.security.model.LoginFailModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TastyFastyFailHandler implements AuthenticationFailureHandler {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        System.out.println("fail");
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.getWriter().print(OBJECT_MAPPER.writeValueAsString(new LoginFailModel()));
    }
}
