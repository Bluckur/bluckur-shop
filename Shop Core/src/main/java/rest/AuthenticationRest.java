package rest;

import models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.AuthenticationService;

@RestController
public class AuthenticationRest {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping("/authentication/greeting")
    public Customer customer(@RequestParam(value="name", defaultValue="World") String name) {
        return new Customer(name, "Rachelsmolen R1 Eindhoven\np.janissen@student.fontys.nl");
    }
}
