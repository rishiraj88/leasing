package allane.leasing.contract.entity.dto;

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

    public Integer getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Integer contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Double getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(Double monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerDTO getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDTO customerDto) {
        this.customerDto = customerDto;
    }

    public VehicleDTO getVehicleDto() {
        return vehicleDto;
    }

    public void setVehicleDto(VehicleDTO vehicleDto) {
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