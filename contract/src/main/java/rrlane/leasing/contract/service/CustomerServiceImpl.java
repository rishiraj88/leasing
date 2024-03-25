package rrlane.leasing.contract.service;

import rrlane.leasing.contract.entity.Customer;
import rrlane.leasing.contract.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        System.out.println("Saving customer...");
        customerRepository.save(customer);
        System.out.println("Saved customer successfully.");
    }

    @Override
    public Customer viewCustomerByName(String name) {
        System.out.println("Retrieving customer details by name...");

        Customer foundCustomer = customerRepository.findByName(name).get(0);
        System.out.println("Retrieved customer details by name successfully.");

        return foundCustomer;
    }

    public Customer viewCustomerByNameAndBirthdate(String name, Date bdate) {
        System.out.println("Retrieving customer details by name and optionally by birth date...");

        List<Customer> foundCustomers = null;
        if (null == bdate) {
            foundCustomers = customerRepository.findByName(name);
        } else {
            foundCustomers = customerRepository.findByNameAndBirthDate(name, bdate);
        }
        Customer foundCustomer = null;
        if (null != foundCustomers && 0 < foundCustomers.size())
            foundCustomer = foundCustomers.get(0);
        System.out.println("Retrieved customer details by name successfully.");

        return foundCustomer;
    }

}