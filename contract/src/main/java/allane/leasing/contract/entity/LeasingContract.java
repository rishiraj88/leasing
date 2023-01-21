package allane.leasing.contract.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Arrays;


@Entity
@Table(name = "lcontract")
@Data
public class LeasingContract {
    @Id
    @Column(name = "contract_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    String id;
    @Column(name = "lcnum")
    Integer contractNumber; //prop
    @Column(name = "mrate")
    Double monthlyRate; //prop
    @OneToOne
    @JoinColumn(name = "vehicle_id") //@JsonManagedReference
    Vehicle vehicle;
    @ManyToOne
            (optional = false)
    @JoinColumn(name = "customer_id")
//    @JsonBackReference
//            @JsonManagedReference
    Customer customer;

    public int hashCode(){
        return (customer.getFirstName() + customer.getLastName()).length();
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
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
