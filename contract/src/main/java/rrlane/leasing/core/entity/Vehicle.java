package rrlane.leasing.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import rrlane.leasing.contract.dto.VehicleDTO;
import rrlane.leasing.util.Mapper;

@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @Column(name = "vehicle_id")
    @UuidGenerator
    private String vehicleId;
    private String brand; //prop: source of truth is here: company brand
    private String model; //prop: source of truth is here: model name
    @Column(name = "myear")
    private String modelYear; //prop: source of truth is here
    private String vin; //prop: source of truth is here: vehicle identification number
    private Double price; //prop: source of truth is here

    public String getDetails() {
        return "" + brand + ' ' + model + " (" + modelYear + ") VIN: " + vin;
    }//TODO check for removal

    public VehicleDTO getDto() {
        return Mapper.entityToDto(this);
    }
}