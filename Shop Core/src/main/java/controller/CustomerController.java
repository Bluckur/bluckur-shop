package controller;

import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Gets the customer with this publicKeyHash.
     * @param publicKeyHash the public key hash of the customer.
     * @return the customer found, null if no customer was found.
     */
    @RequestMapping(method= RequestMethod.GET, value="/customer/get/{publicKeyHash}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity customer(@PathVariable(value="publicKeyHash") String publicKeyHash) {
        Customer customer = this.customerService.getCustomer(publicKeyHash);
        return new ResponseEntity(customer, HttpStatus.OK);
    }
}
