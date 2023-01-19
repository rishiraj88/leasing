package allane.leasing.contract.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;
    @Column(name = "lcnum")
    Integer contractNumber; //prop
    @Column(name = "mrate")
    Double monthlyRate; //prop
    @OneToOne
    @JoinColumn(name = "vehicle_id") @JsonManagedReference
    Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name = "customer_id") @JsonManagedReference
    Customer customer;

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
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
