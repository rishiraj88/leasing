package rrlane.leasing.service;

import rrlane.leasing.contract.dto.CustomerDTO;

import java.time.LocalDateTime;

public interface CustomerService {
    public String saveCustomer(CustomerDTO customerDTO);

    public CustomerDTO viewCustomerByName(String name);
public CustomerDTO searchForCustomer(CustomerDTO customerDTO);
}
