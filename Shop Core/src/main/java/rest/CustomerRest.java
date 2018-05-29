package rest;

import models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CustomerService;

@RestController
public class CustomerRest {

    @Autowired
    private CustomerService customerService;

    /**
     * Gets the customer with this publicKeyHash.
     * @param publicKeyHash the public key hash of the customer.
     * @return the customer found, null if no customer was found.
     */
    @RequestMapping(method= RequestMethod.GET, value="/customer/get/{publicKeyHash}")
    public Customer customer(@PathVariable(value="publicKeyHash") String publicKeyHash) {
        return this.customerService.getCustomer(publicKeyHash);
    }
}
