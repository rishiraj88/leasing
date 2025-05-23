package rrlane.leasing.core.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    // to create a customer with POST and also to edit a customer with PATCH
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PATCH})
    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    public ResponseEntity<CustomerDTO> uploadCustomer(@RequestBody CustomerDTO customerDTO) {
        log.info("Uploading customer details to server...");
        HttpStatus responseStatus = HttpStatus.OK; // for update
        String responseFromService = customerService.saveCustomer(customerDTO);
        if (responseFromService.contains("created")) {
            responseStatus = HttpStatus.CREATED; // for new customer record creation
        }
        log.info(responseFromService);
        return new ResponseEntity<>(customerDTO, responseStatus);
    }

    // to retrieve the details of a customer with matching inputs (search criteria)
    @GetMapping()
    public ResponseEntity<CustomerDTO> getCustomer(@RequestBody CustomerDTO customerDTO) {
        log.info("Searching for customer details on server...");
        CustomerDTO retrievedCustomerDTO = customerService.searchForCustomer(customerDTO);
        if (null == retrievedCustomerDTO) {
            log.error("Customer details could not be found on server.");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        log.info("Found the customer details with name (as per records): " + retrievedCustomerDTO.getName());
        return new ResponseEntity<>(retrievedCustomerDTO, HttpStatus.OK);
    }
}
