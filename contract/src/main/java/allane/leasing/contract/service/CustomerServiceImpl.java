package allane.leasing.contract.service;

import allane.leasing.contract.entity.Customer;
import allane.leasing.contract.repo.CustomerRepository;
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

        String[] names = name.split(" ");
        Customer retCustomer = customerRepository.findByFirstNameAndLastName(names[0], names[1]).get(0);
        System.out.println("Retrieved customer details by name successfully.");

        return retCustomer;
    }

    public Customer viewCustomerByNameAndBirthdate(String name, Date bdate) {
        System.out.println("Retrieving customer details by name and optionally by birth date...");

        String[] names = name.split(" ");
        List<Customer> retCustomers = null;
        if (null == bdate) {
            retCustomers = customerRepository.findByFirstNameAndLastName(names[0], names[1]);
        } else {
            retCustomers = customerRepository.findByFirstNameAndLastNameAndBirthDate(names[0], names[1], bdate);
        }
        Customer retCustomer = null;
        if (null != retCustomers && 0 < retCustomers.size())
            retCustomer = retCustomers.get(0);
        System.out.println("Retrieved customer details by name successfully.");

        return retCustomer;
    }

}