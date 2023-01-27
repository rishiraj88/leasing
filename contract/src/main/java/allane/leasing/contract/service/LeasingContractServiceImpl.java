package allane.leasing.contract.service;

import allane.leasing.contract.entity.Customer;
import allane.leasing.contract.entity.LeasingContract;
import allane.leasing.contract.entity.Vehicle;
import allane.leasing.contract.repo.LeasingContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class LeasingContractServiceImpl implements LeasingContractService {

    @Autowired
    private LeasingContractRepository leasingContractRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private VehicleService vehicleService;

    @Override
    public void saveLeasingContract(LeasingContract contract) {
        System.out.println("Saving contract...");
        leasingContractRepository.save(contract);
        System.out.println("Saved contract successfully.");

    }

    public LeasingContract viewContractByContractNumber(Integer contractNumber) {
        System.out.println("Retrieving contract by contract number...");
        LeasingContract retLeasingContract = leasingContractRepository.findByContractNumber(contractNumber).get(0);
        System.out.println("Retrieved contract by contract number successfully.");
        return retLeasingContract;
    }

    public List<LeasingContract> viewContractByMonthlyRate(Double monthlyRate) {
        System.out.println("Retrieving contracts by monthly rate...");
        List<LeasingContract> retLeasingContracts = leasingContractRepository.findByMonthlyRate(monthlyRate);
        System.out.println("Retrieved contracts by monthly rate successfully.");
        return retLeasingContracts;
    }
    public List<LeasingContract> viewContractByCustomerName(String customerName) {
        return viewContractByCustomer(getCustomerByName(customerName));
    }
    public Customer getCustomerByName(String customerName) {
        return customerService.viewCustomerByName(customerName);
    }

    public List<LeasingContract> viewContractByCustomer(Customer customer) {
        System.out.println("Retrieving contracts by customer...");
        List<LeasingContract> retLeasingContracts = leasingContractRepository.findByCustomer(customer);
        System.out.println("Retrieved contracts by customer successfully.");
        return retLeasingContracts;
    }

    public Vehicle getVehicleByDetails(String vehicleDetails) {
        String[] details = vehicleDetails.replace("VIN:"," ").replace("("," ")
                .replace(")"," ").replaceAll("\\s+"," ")
                .split(" ");
        System.out.println("details array: ");
        String[] preparedDetails = Arrays.stream(details).filter(a -> a.length()>0).toArray(String[]::new);
        return vehicleService.getVehiclesByDetails(preparedDetails).get(0);
    }
    public LeasingContract viewContractByVehicle(Vehicle vehicle) {
        System.out.println("Retrieving contract by vehicle...");
        LeasingContract retLeasingContract = leasingContractRepository.findByVehicle(vehicle);
        System.out.println("Retrieved contract by vehicle successfully.");
        return retLeasingContract;
    }

    @Override
    public List<LeasingContract> view() {
        return leasingContractRepository.findAll();
    }
}
