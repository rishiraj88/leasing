package rrlane.leasing.contract.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class VehicleDTO {
    private String brand; //prop: company brand
    private String model; //prop: model name
    private String myear; //prop: model year
    private String vin; //prop: vehicle identification number
    private Double price;

    @Override
    public String toString() {
        return "VehicleDTO{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + ", year='" + myear + '\'' + ", vin='" + vin + '\'' + ", price=" + price + '}';
    }
}
