package controller;

import domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @RequestMapping("/authentication/greeting")
    public ResponseEntity customer(@RequestParam(value="name", defaultValue="World") String name) {
        Customer customer = new Customer(name, "Rachelsmolen R1 Eindhoven\np.janissen@student.fontys.nl");
        return new ResponseEntity(customer, HttpStatus.OK);
    }
}
