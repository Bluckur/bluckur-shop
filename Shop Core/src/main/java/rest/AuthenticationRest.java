package rest;

import domain.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationRest {

    @RequestMapping("/authentication/greeting")
    public Customer customer(@RequestParam(value="name", defaultValue="World") String name) {
        return new Customer(name, "Rachelsmolen R1 Eindhoven\np.janissen@student.fontys.nl");
    }
}
