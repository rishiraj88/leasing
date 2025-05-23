package rrlane.leasing.core.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rrlane.leasing.contract.dto.CustomerDTO;
import rrlane.leasing.core.Constants;
import rrlane.leasing.core.entity.Customer;
import rrlane.leasing.core.repo.CustomerRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public String saveCustomer(CustomerDTO customerDTO) {
        log.info("Uploading customer details to server...");

        String response = "";
        Customer customer = null;
        List<Customer> foundCustomers = customerRepository.findByName(customerDTO.getName());
        if (!foundCustomers.isEmpty()) {
            customer = foundCustomers.get(0);
            customer.setBirthDate(customerDTO.getBirthDate());
            customerRepository.save(customer);
            System.out.println(Constants.CUSTOMER_UPDATED);
            return Constants.CUSTOMER_UPDATED;
        }

        foundCustomers = customerRepository.findByBirthDate(customerDTO.getBirthDate());
        if (!foundCustomers.isEmpty()) {
            customer = foundCustomers.get(0);
            customer.setName(customerDTO.getName());
            customerRepository.save(customer);
            System.out.println(Constants.CUSTOMER_UPDATED);
            return Constants.CUSTOMER_UPDATED;
        }

        customer = Customer.builder().name(customerDTO.getName()).birthDate(customerDTO.getBirthDate()).build();
        customerRepository.save(customer);
        System.out.println(Constants.CUSTOMER_ADDED);
        return Constants.CUSTOMER_ADDED;
    }

    public CustomerDTO searchForCustomer(CustomerDTO customerDTO) {
        return getCustomerByNameAndBirthDate(customerDTO.getName(), customerDTO.getBirthDate());
    }

    private CustomerDTO getCustomerByNameAndBirthDate(String name, LocalDate bdate) {
        log.info("Retrieving customer details by name and optionally by birth date...");
        List<Customer> foundCustomers = null;
        if (null == bdate) {
            foundCustomers = customerRepository.findByName(name);
        } else {
            foundCustomers = customerRepository.findByNameAndBirthDate(name, bdate);
        }
        if (null != foundCustomers && 0 < foundCustomers.size()) {
            Customer foundCustomer = foundCustomers.get(0);
            log.info(Constants.CUSTOMER_FOUND);
            CustomerDTO foundCustomerDTO = CustomerDTO.builder().name(foundCustomer.getName()).birthDate(foundCustomer.getBirthDate()).build();
            return foundCustomerDTO;
        }
        log.info("Customer details not available on server.");
        return null;
    }

    @Override
    public CustomerDTO viewCustomerByName(String name) {
        System.out.println("Retrieving customer details by name...");
        Customer foundCustomer = customerRepository.findByName(name).get(0);
        System.out.println(Constants.CUSTOMER_FOUND);
        CustomerDTO foundCustomerDTO = CustomerDTO.builder().name(foundCustomer.getName()).birthDate(foundCustomer.getBirthDate()).build();
        return foundCustomerDTO;
    }
}