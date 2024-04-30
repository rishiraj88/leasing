package rrlane.leasing.service;

import rrlane.leasing.entity.Customer;

import java.time.LocalDateTime;

public interface CustomerService {
    public void saveCustomer(Customer customer);
    public Customer viewCustomerByName(String name);
    public Customer viewCustomerByNameAndBirthdate(String name, LocalDateTime birthDate);

}
