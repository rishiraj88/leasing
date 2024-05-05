package rrlane.leasing.common.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rrlane.leasing.contract.dto.CustomerDTO;
import rrlane.leasing.service.CustomerService;

/**
 * Note for readers:
 * The API methods have not been designed in old (more verbose) fashion.
 * Kindly read through the code closely to appreciate the compact yet extensible approach well.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;

    // to create a customer with POST and also to edit a customer with PUT
    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PUT})
    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO)  {
        HttpStatus responseStatus = HttpStatus.OK;
        String responseFromService = customerService.saveCustomer(customerDTO);
        if (responseFromService.contains("created")) responseStatus = HttpStatus.CREATED;
        return new ResponseEntity<>(customerDTO, responseStatus);
    }

    // to retrieve the details of a customer with matching inputs (search criteria)
    @GetMapping("/")
    public ResponseEntity<CustomerDTO> viewCustomer(@RequestBody CustomerDTO customerDTO)  {
        CustomerDTO retrievedCustomerDTO  = customerService.searchForCustomer(customerDTO);
        if (null == retrievedCustomerDTO) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        System.out.println("Found the customer: " + retrievedCustomerDTO);
        return new ResponseEntity<>(retrievedCustomerDTO, HttpStatus.OK);
    }
}
