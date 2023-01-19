package allane.leasing.contract.service;

import allane.leasing.contract.entity.Customer;

public interface CustomerService {
    public void saveCustomer(Customer customer);
    public Customer viewCustomerByName(String name, String birthDate);
}
