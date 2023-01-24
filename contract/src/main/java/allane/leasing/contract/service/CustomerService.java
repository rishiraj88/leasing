package allane.leasing.contract.service;

import allane.leasing.contract.entity.Customer;

import java.util.Date;

public interface CustomerService {
    public void saveCustomer(Customer customer);
    public Customer viewCustomerByName(String name, String birthDate);
    public Customer viewCustomerByNameAndBirthdate(String name, Date birthDate);

}
