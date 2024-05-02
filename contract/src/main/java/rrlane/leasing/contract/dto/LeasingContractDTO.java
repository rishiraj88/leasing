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

    public LeasingContractDTO() {
    }

    public LeasingContractDTO(Integer contractNumber, Double monthlyRate, String vehicleDetails, String customerName) {
        this.contractNumber = contractNumber;
        this.monthlyRate = monthlyRate;
        this.vehicleDetails = vehicleDetails;
        this.customerName = customerName;
    }

    public LeasingContractDTO(Integer contractNumber, Double monthlyRate, String vehicleDetails, String customerName, CustomerDTO customerDto, VehicleDTO vehicleDto) {
        this.contractNumber = contractNumber;
        this.monthlyRate = monthlyRate;
        this.vehicleDetails = vehicleDetails;
        this.customerName = customerName;
        this.customerDto = customerDto;
        this.vehicleDto = vehicleDto;
    }

    @Override
    public String toString() {
        return "LeasingContractDTO{" +
                "contractNumber=" + contractNumber +
                ", monthlyRate=" + monthlyRate +
                ", vehicleDetails='" + vehicleDetails + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerDto=" + customerDto +
                ", vehicleDto=" + vehicleDto +
                '}';
    }
}