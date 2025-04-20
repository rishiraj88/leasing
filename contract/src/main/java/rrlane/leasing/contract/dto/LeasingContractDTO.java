package rrlane.leasing.contract.dto;

import lombok.Data;

@Data
public class LeasingContractDTO {
    private Integer contractNumber;
    private Double monthlyRate;
    private String vehicleDetails;
    private String customerName;
    private CustomerDTO customerDto;
    private VehicleDTO vehicleDto;
}