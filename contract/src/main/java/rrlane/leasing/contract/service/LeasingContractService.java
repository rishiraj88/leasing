package rrlane.leasing.contract.service;

import rrlane.leasing.contract.dto.CustomerDTO;
import rrlane.leasing.contract.dto.LeasingContractDTO;
import rrlane.leasing.contract.entity.LeasingContract;
import rrlane.leasing.entity.Vehicle;

import java.util.List;

public interface LeasingContractService {
    public String saveLeasingContract(LeasingContractDTO contractDTO);

    public CustomerDTO getCustomerByName(String customerName);

    public Vehicle getVehicleByDetails(String vehicleDetails);

    public List<LeasingContract> view();
}
