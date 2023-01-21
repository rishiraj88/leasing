package allane.leasing.contract.controller;

import allane.leasing.contract.entity.Customer;
import allane.leasing.contract.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    private Customer customer=null;

    // to create a customer
    @PostMapping ("/")
    public ResponseEntity<Customer> addCustomer(@RequestParam String fname,@RequestParam String lname, @RequestParam String bdate) throws ParseException {
        customer = new Customer();

        customer = new Customer();
        customer.setFirstName(fname);
        customer.setLastName(lname);
        Date birthDate =new SimpleDateFormat("dd.MM.yyyy").parse(bdate);
        customer.setBirthDate(birthDate);

        customerService.saveCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
    // to save a customer upon editing details
    @PutMapping("/")
    public ResponseEntity<Customer> editCustomer(@RequestParam String fname,@RequestParam String lname,
                                                 @RequestParam String bdate) throws ParseException {
        //editing the pre-retieved customer
        //should be a branching strategy in frontend to choose:
        //a. to editing the lastly retrieved customer
        //b. to clear the customer reference (which may be to the lastly retrieved customer) and add a new customer with PostMapping
        customer.setFirstName(fname);
        customer.setLastName(lname);
        Date birthDate =new SimpleDateFormat("dd.MM.yyyy").parse(bdate);
        customer.setBirthDate(birthDate);

        customerService.saveCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
