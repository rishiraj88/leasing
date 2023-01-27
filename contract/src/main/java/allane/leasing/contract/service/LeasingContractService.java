package allane.leasing.contract.service;

import allane.leasing.contract.entity.Customer;
import allane.leasing.contract.entity.LeasingContract;
import allane.leasing.contract.entity.Vehicle;

import java.util.List;

public interface LeasingContractService {
    public void saveLeasingContract(LeasingContract contract);

    public Customer getCustomerByName(String customerName);

     Vehicle getVehicleByDetails(String vehicleDetails);
     public     List<LeasingContract> view();
}
