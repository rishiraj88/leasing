package allane.leasing.contract.service;

import allane.leasing.contract.entity.Customer;
import allane.leasing.contract.entity.LeasingContract;
import allane.leasing.contract.entity.Vehicle;

public interface LeasingContractService {
    public void saveLeasingContract(LeasingContract contract);

    public Customer getCustomerByName(String customerName);

    Vehicle getVehicleByDetails(String vehicleDetails);
}
