package rrlane.leasing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import rrlane.leasing.contract.dto.VehicleDTO;
import rrlane.leasing.util.Mapper;

@Entity
@NoArgsConstructor @Data @Builder @AllArgsConstructor
@Table(name = "vehicle")
public class Vehicle {
@Id
@Column(name = "vehicle_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String vehicleId;
    private String brand; //prop: company brand
    private String model; //prop: model name
    @Column(name = "myear")
    private String modelYear;
    private String vin; //prop: vehicle identification number
    private Double price;

    public String getDetails() {
        return "" + brand + ' ' + model + " (" + modelYear +") VIN: " + vin;
    }

    public VehicleDTO getDto() {
        return Mapper.entityToDto(this);
    }
}