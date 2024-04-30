package rrlane.leasing.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rrlane.leasing.contract.entity.dto.CustomerDTO;
import rrlane.leasing.entity.Customer;
import rrlane.leasing.service.CustomerService;
import rrlane.leasing.util.Mapper;

import java.text.ParseException;

/**
 * Note for readers:
 * The API methods have not been designed in old (more verbose) fashion.
 * Kindly read through the code closely to appreciate the compact yet extensible approach well.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    private Customer customer = null;

    // to create a customer with POST and also to edit a customer with PUT
    @RequestMapping(value = "/",method = {RequestMethod.POST, RequestMethod.PUT})
    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO) throws ParseException {
        HttpStatus status = HttpStatus.OK;
        if(null == customer) {
            customer = new Customer();
            status = HttpStatus.CREATED;
        }
        customer.setName(customerDTO.getName());
        customer.setBirthDate(customerDTO.getBirthDate());

        customerService.saveCustomer(customer);
     customerDTO=   Mapper.entityToDto(customer);
        return new ResponseEntity<>(customerDTO,status);
    }

    // to retrieve the details of a customer with matching inputs (search criteria)
    @GetMapping("/")
    public ResponseEntity<CustomerDTO> viewCustomer(@RequestBody CustomerDTO customerDTO) throws ParseException {

        customer =
                customerService.viewCustomerByNameAndBirthdate(customerDTO.getName(), customerDTO.getBirthDate());
        if (null == customer) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        customerDTO = Mapper.entityToDto(customer);
        System.out.println("Customer by name: " + customer);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

}
