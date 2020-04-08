package ru.relex.tastyfasty.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import ru.relex.tastyfasty.security.model.LoginFailModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TastyFastyLogoutSuccessHandler implements LogoutSuccessHandler {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        System.out.println("logout");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().print(OBJECT_MAPPER.writeValueAsString(new LoginFailModel()));
    }
}
