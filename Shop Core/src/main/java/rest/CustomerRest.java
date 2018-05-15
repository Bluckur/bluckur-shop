package rest;

import Models.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerRest {

    /**
     * Gets the customer with this publicKeyHash.
     * @param publicKeyHash the public key hash of the customer.
     * @return the customer found, null if no customer was found.
     */
    @RequestMapping(method= RequestMethod.GET, value="/customer/get/{publicKeyHash}")
    public Customer customer(@PathVariable(value="publicKeyHash") String publicKeyHash) {
        return new Customer(publicKeyHash, "Rachelsmolen R1 Eindhoven\np.janissen@student.fontys.nl");
    }
}
