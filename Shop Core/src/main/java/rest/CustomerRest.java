package rest;

import domain.Customer;
import org.springframework.web.bind.annotation.*;
import service.CustomerService;
import service.CustomerServiceImpl;

@RestController
public class CustomerRest {

    private CustomerService customerService;

    public CustomerRest() {
        this.customerService = new CustomerServiceImpl();
    }

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
