package rrlane.leasing.contract.controller;

import rrlane.leasing.contract.entity.Customer;
import rrlane.leasing.contract.entity.dto.CustomerDTO;
import rrlane.leasing.contract.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    private Customer customer = null;

    // to create a customer with POST
    // also, to save a customer upon editing details with PUT
    @RequestMapping(value = "/",method = {RequestMethod.POST, RequestMethod.PUT})
    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDTO customerDTO) throws ParseException {
        HttpStatus status = HttpStatus.OK;
        if(null == customer) {
            customer = new Customer();
            status = HttpStatus.CREATED;
        }
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(customerDTO.getBirthDate());
        customer.setBirthDate(birthDate);

        customerService.saveCustomer(customer);
        return new ResponseEntity<>(customer,status);
    }

    // to retrieve a customer
    @GetMapping("/")
    public ResponseEntity<Customer> viewCustomer(@RequestBody CustomerDTO customerDTO) throws ParseException {
        Date birthDate = null;
        if (null != customerDTO.getBirthDate())
            birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(customerDTO.getBirthDate());

        customer =
                customerService.viewCustomerByNameAndBirthdate(customerDTO.getFirstName() + " " +
                        customerDTO.getLastName(), birthDate);
        if (null == customer) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        System.out.println("Customer by name: " + customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
