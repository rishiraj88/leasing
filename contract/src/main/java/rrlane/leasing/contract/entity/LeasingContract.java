package rrlane.leasing.contract.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import rrlane.leasing.entity.Customer;
import rrlane.leasing.entity.Vehicle;

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
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public int hashCode() {
        return customer.getName().length();
    }

    public boolean equals(Object obj) {
        if (obj instanceof LeasingContract) {
            return this.id.equals(((LeasingContract) obj).getId());
        }
        return false;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        if (null == this.vehicle.getVin() || "".equals(this.vehicle.getVin())) this.vehicle.setVin("-");
    }

}