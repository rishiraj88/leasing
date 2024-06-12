package rrlane.leasing.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rrlane.leasing.contract.dto.CustomerDTO;
import rrlane.leasing.core.service.CustomerService;

/**
 * Note for readers:
 * The API methods have not been designed in old (more verbose) fashion.
 * Kindly read through the code closely to appreciate the compact yet extensible approach well.
 */
@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    private CustomerService customerService;
    private Logger logs;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
        logs = LoggerFactory.getLogger(CustomerController.class);
    }

    // to create a customer with POST and also to edit a customer with PUT
    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PATCH})
    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO) {
        logs.info("Sending customer details to server...");
        HttpStatus responseStatus = HttpStatus.OK;
        String responseFromService = customerService.saveCustomer(customerDTO);
        if (responseFromService.contains("created")) {
            responseStatus = HttpStatus.CREATED;
        }
        logs.info(responseFromService);
        return new ResponseEntity<>(customerDTO, responseStatus);
    }

    // to retrieve the details of a customer with matching inputs (search criteria)
    @GetMapping("/")
    public ResponseEntity<CustomerDTO> viewCustomer(@RequestBody CustomerDTO customerDTO) {
        logs.info("Searching for customer details on server...");
        CustomerDTO retrievedCustomerDTO = customerService.searchForCustomer(customerDTO);
        if (null == retrievedCustomerDTO) {
            logs.error("Customer details could not be found on server.");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }
        logs.info("Found the customer details with name: " + retrievedCustomerDTO.getName());
        return new ResponseEntity<>(retrievedCustomerDTO, HttpStatus.OK);
    }
}
