package rrlane.leasing.contract.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lcontract")
@Data
public class LeasingContract {
    @Id
    @Column(name = "contract_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @Column(name = "lcnum")
    private Integer contractNumber;
    @Column(name = "mrate")
    private Double monthlyRate;
    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @ManyToOne
            (optional = false)
    @JoinColumn(name = "customer_id")
    private rrlane.leasing.contract.entity.Customer customer;

    public int hashCode(){
        return customer.getName().length();
    }

    public boolean equals(Object obj) {
        if(obj instanceof  LeasingContract) {
            return this.id.equals(((LeasingContract) obj).getId());
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        if(null == this.vehicle.getVin() || "".equals(this.vehicle.getVin()))
            this.vehicle.setVin("-");
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}