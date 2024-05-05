package rrlane.leasing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rrlane.leasing.common.Constants;
import rrlane.leasing.contract.dto.CustomerDTO;
import rrlane.leasing.entity.Customer;
import rrlane.leasing.repo.CustomerRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public String saveCustomer(CustomerDTO customerDTO) {
        System.out.println("Saving/Updating customer details...");
        String response = "";
        Customer customer = null;

        customer = customerRepository.findByName(customerDTO.getName()).get(0);
        if (null != customer) {
            customer.setBirthDate(customerDTO.getBirthDate());
            customerRepository.save(customer);
            System.out.println(Constants.CUSTOMER_UPDATED);
            return  Constants.CUSTOMER_UPDATED;
        }
        customer = customerRepository.findByBirthDate(customerDTO.getBirthDate()).get(0);
        if (null != customer) {
            customer.setName(customerDTO.getName());
            customerRepository.save(customer);
            System.out.println(Constants.CUSTOMER_UPDATED);
            return  Constants.CUSTOMER_UPDATED;
        }
        customer = Customer.builder().name(customerDTO.getName()).birthDate(customerDTO.getBirthDate()).build();
        customerRepository.save(customer);
        System.out.println(Constants.CUSTOMER_ADDED);
        return Constants.CUSTOMER_ADDED;
    }
    public CustomerDTO searchForCustomer(CustomerDTO customerDTO){
        return getCustomerByNameAndBirthdate(customerDTO.getName(),customerDTO.getBirthDate());
    }
    private CustomerDTO getCustomerByNameAndBirthdate(String name, LocalDate bdate) {
        System.out.println("Retrieving customer details by name and optionally by birth date...");
        List<Customer> foundCustomers = null;
        if (null == bdate) {
            foundCustomers = customerRepository.findByName(name);
        } else {
            foundCustomers = customerRepository.findByNameAndBirthDate(name, bdate);
        }
        Customer foundCustomer = null;
        if (null != foundCustomers && 0 < foundCustomers.size()) foundCustomer = foundCustomers.get(0);
        System.out.println(Constants.CUSTOMER_FOUND);
        CustomerDTO foundCustomerDTO = CustomerDTO.builder()
                .name(foundCustomer.getName())
                .birthDate(foundCustomer.getBirthDate())
                .build();
        return foundCustomerDTO;
    }
    @Override
    public CustomerDTO viewCustomerByName(String name) {
        System.out.println("Retrieving customer details by name...");
        Customer foundCustomer = customerRepository.findByName(name).get(0);
        System.out.println(Constants.CUSTOMER_FOUND);
        CustomerDTO foundCustomerDTO = CustomerDTO.builder()
                .name(foundCustomer.getName())
                .birthDate(foundCustomer.getBirthDate())
                .build();
        return foundCustomerDTO;
    }


}