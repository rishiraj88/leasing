package allane.leasing.contract.service;

import allane.leasing.contract.entity.Customer;
import allane.leasing.contract.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Customer viewCustomerByName(String name, String bdate) {
        System.out.println("Retrieving customer details by name...");

        String[] names = name.split(" ");
        Customer retCustomer = customerRepository.findByFirstNameAndLastName(names[0],names[1]).get(0);
        System.out.println("Retrieved customer details by name successfully.");

        return retCustomer;
    }
}