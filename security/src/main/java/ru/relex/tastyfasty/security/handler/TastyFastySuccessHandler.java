package ru.relex.tastyfasty.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ru.relex.commons.model.CurrentUser;
import ru.relex.tastyfasty.security.model.LoginSuccessModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TastyFastySuccessHandler implements AuthenticationSuccessHandler {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException {

        if (!(authentication.getPrincipal() instanceof CurrentUser)) {
            throw new AuthenticationServiceException("User instance not of CurrentUser!");
        }
        CurrentUser principal = (CurrentUser) authentication.getPrincipal();

        System.out.println("login");
        response.setStatus(HttpServletResponse.SC_OK);
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.getWriter().print(OBJECT_MAPPER.writeValueAsString(new LoginSuccessModel(principal)));
    }

}
