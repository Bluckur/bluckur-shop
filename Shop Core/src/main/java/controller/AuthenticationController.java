package controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.AuthenticationService;

import javax.servlet.ServletException;
import java.util.Date;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping("/authentication/login")
    public String login(@RequestParam("identifier") String identifier, @RequestParam("password") String password) throws ServletException {
        final String adminPassword="QWERTY12345";

        String jwtToken = "";

        if (password == null || password.isEmpty()) {
            throw new ServletException("Please fill in username and password");
        }

        if (!password.equals(adminPassword)) {
            throw new ServletException("Invalid login. Please check your name and password.");
        }

        jwtToken = Jwts.builder().setSubject(identifier).claim("roles", "ADMIN").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "SecretKey").compact();

        return jwtToken;
    }
}
