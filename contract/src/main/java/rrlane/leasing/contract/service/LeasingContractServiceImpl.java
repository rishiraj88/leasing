package rrlane.leasing.contract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rrlane.leasing.contract.dto.CustomerDTO;
import rrlane.leasing.contract.dto.LeasingContractDTO;
import rrlane.leasing.contract.entity.LeasingContract;
import rrlane.leasing.contract.repo.LeasingContractRepository;
import rrlane.leasing.core.Constants;
import rrlane.leasing.core.entity.Customer;
import rrlane.leasing.core.entity.Vehicle;
import rrlane.leasing.core.service.CustomerService;
import rrlane.leasing.core.service.VehicleService;
import rrlane.leasing.util.Mapper;

import java.util.Arrays;
import java.util.List;

@Service
public class LeasingContractServiceImpl implements LeasingContractService {
    private final LeasingContractRepository leasingContractRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private VehicleService vehicleService;

    public LeasingContractServiceImpl(LeasingContractRepository leasingContractRepository) {
        this.leasingContractRepository = leasingContractRepository;
    }

    @Override
    public String saveLeasingContract(LeasingContractDTO contractDTO) {
        if (null != contractDTO && -1 == contractDTO.getMonthlyRate()) {
            throw new IllegalArgumentException("Negative monthly rates are bad.");
        }
        if (null == contractDTO.getCustomerName() || contractDTO.getCustomerName().equals("")) {
            throw new IllegalArgumentException("Customer name must be entered.");
        }
        ///
        System.out.println("Saving/Updating the details of leasing contract...");
        String response = "";
        LeasingContract contract = null;
        contract = leasingContractRepository.findByContractNumber(contractDTO.getContractNumber()).get(0);
        if (null != contract) {
            contract.setMonthlyRate(contractDTO.getMonthlyRate());
            contract.setCustomer(Mapper.dtoToEntity(contractDTO.getCustomerDto()));
            contract.setVehicle(Mapper.dtoToEntity(contractDTO.getVehicleDto()));
            leasingContractRepository.save(contract);
            System.out.println(Constants.LEASING_CONTRACT_UPDATED);
            return Constants.LEASING_CONTRACT_UPDATED;
        }
        contract = leasingContractRepository.findByCustomer(Mapper.dtoToEntity(contractDTO.getCustomerDto())).get(0);
        if (null != contract) {
            contract.setMonthlyRate(contractDTO.getMonthlyRate());
            contract.setVehicle(Mapper.dtoToEntity(contractDTO.getVehicleDto()));
            leasingContractRepository.save(contract);
            System.out.println(Constants.LEASING_CONTRACT_UPDATED);
            return Constants.LEASING_CONTRACT_UPDATED;
        }
        contract = LeasingContract.builder().contractNumber(contractDTO.getContractNumber()).customer(Mapper.dtoToEntity(contractDTO.getCustomerDto())).vehicle(Mapper.dtoToEntity(contractDTO.getVehicleDto())).build();
        leasingContractRepository.save(contract);
        System.out.println(Constants.LEASING_CONTRACT_ADDED);
        return Constants.LEASING_CONTRACT_ADDED;
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

    public CustomerDTO getCustomerByName(String customerName) {
        return customerService.viewCustomerByName(customerName);
    }

    public List<LeasingContract> viewContractByCustomer(CustomerDTO customerDTO) {
        System.out.println("Retrieving contracts by customer...");
        Customer customer = Mapper.dtoToEntity(customerDTO);
        List<LeasingContract> retLeasingContracts = leasingContractRepository.findByCustomer(customer);
        System.out.println("Retrieved contracts by customer successfully.");
        return retLeasingContracts;
    }

    //TODO to use or remove
    public Vehicle getVehicleByDetails(String vehicleDetails) {
        String[] details = vehicleDetails.replace("VIN:", " ").replace("(", " ").replace(")", " ").replaceAll("\\s+", " ").split(" ");
        System.out.println("details array: ");
        String[] preparedDetails = Arrays.stream(details).filter(a -> a.length() > 0).toArray(String[]::new);
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
