package rrlane.leasing.contract.service;

import rrlane.leasing.contract.entity.Customer;
import rrlane.leasing.contract.entity.LeasingContract;
import rrlane.leasing.contract.entity.Vehicle;

import java.util.List;

public interface LeasingContractService {
    public void saveLeasingContract(LeasingContract contract);

    public Customer getCustomerByName(String customerName);

     Vehicle getVehicleByDetails(String vehicleDetails);
     public     List<LeasingContract> view();
}
