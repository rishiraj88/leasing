package rrlane.leasing.contract.service;

import rrlane.leasing.contract.entity.Customer;

import java.util.Date;

public interface CustomerService {
    public void saveCustomer(Customer customer);
    public Customer viewCustomerByName(String name);
    public Customer viewCustomerByNameAndBirthdate(String name, Date birthDate);

}
