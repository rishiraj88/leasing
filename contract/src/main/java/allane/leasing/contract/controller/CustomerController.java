package allane.leasing.contract.controller;

import allane.leasing.contract.entity.Customer;
import allane.leasing.contract.entity.dto.CustomerDTO;
import allane.leasing.contract.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    // to create a customer
    @PostMapping("/")
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDTO customerDTO) throws ParseException {
        customer = new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        Date birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(customerDTO.getBirthDate());
        customer.setBirthDate(birthDate);

        customerService.saveCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    // to save a customer upon editing details
    @PutMapping("/")
    public ResponseEntity<Customer> editCustomer(@RequestBody CustomerDTO customerDTO) throws ParseException {
        //editing the pre-retieved customer
        //should be a branching strategy in frontend to choose:
        //a. to editing the lastly retrieved customer
        //b. to clear the customer reference (which may be to the lastly retrieved customer) and add a new customer with PostMapping
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        Date birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(customerDTO.getBirthDate());
        customer.setBirthDate(birthDate);

        customerService.saveCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
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
