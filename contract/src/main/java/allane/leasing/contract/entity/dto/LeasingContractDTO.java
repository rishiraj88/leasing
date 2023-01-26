package allane.leasing.contract.entity.dto;

public class LeasingContractDTO {
    private Integer contractNo; //prop
    private Double mRate; //prop
    private String vehicle; // need to extract vehicle id from vehicle details
    private String customer;

    public Integer getContractNo() {
        return contractNo;
    }

    public void setContractNo(Integer contractNo) {
        this.contractNo = contractNo;
    }

    public Double getmRate() {
        return mRate;
    }

    public void setmRate(Double mRate) {
        this.mRate = mRate;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "LeasingContractDTO{" +
                "contractNo=" + contractNo +
                ", mRate=" + mRate +
                ", vehicle='" + vehicle + '\'' +
                ", customer='" + customer + '\'' +
                '}';
    }
}