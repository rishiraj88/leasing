package rrlane.leasing.util;

import rrlane.leasing.contract.dto.CustomerDTO;
import rrlane.leasing.contract.dto.LeasingContractDTO;
import rrlane.leasing.contract.dto.VehicleDTO;
import rrlane.leasing.contract.entity.LeasingContract;
import rrlane.leasing.entity.Customer;
import rrlane.leasing.entity.Vehicle;

public class Mapper {
    public static CustomerDTO entityToDto(Customer entity) {
        CustomerDTO dto = new CustomerDTO();
        dto.setName(entity.getName());
        dto.setBirthDate(entity.getBirthDate());
        return dto;
    }

    public static Customer dtoToEntity(CustomerDTO dto) {
        Customer entity = new Customer();
        entity.setName(dto.getName());
        entity.setBirthDate(dto.getBirthDate());
        return entity;
    }

    public static LeasingContractDTO entityToDto(LeasingContract entity) {
        LeasingContractDTO dto = new LeasingContractDTO();
        dto.setContractNumber(entity.getContractNumber());
        dto.setMonthlyRate(entity.getMonthlyRate());
        dto.setCustomerDto(entity.getCustomer().getDto());
        dto.setVehicleDto(entity.getVehicle().getDto());
        return dto;
    }

    public static Vehicle dtoToEntity(VehicleDTO dto) {
        Vehicle entity = new Vehicle();
        entity.setBrand(dto.getBrand());
        entity.setModel(dto.getModel());
        entity.setModelYear(dto.getYear());
        entity.setVin(dto.getVin());
        entity.setPrice(dto.getPrice());
        return entity;
    }

    public static VehicleDTO entityToDto(Vehicle entity) {
        VehicleDTO dto = new VehicleDTO();
        dto.setBrand(entity.getBrand());
        dto.setModel(entity.getModel());
        dto.setYear(entity.getModelYear());
        dto.setVin(entity.getVin());
        dto.setPrice(entity.getPrice());
        return dto;
    }
}
