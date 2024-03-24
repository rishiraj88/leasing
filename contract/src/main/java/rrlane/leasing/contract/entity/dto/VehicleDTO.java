package rrlane.leasing.contract.entity.dto;

public class VehicleDTO {
    private String brand; //prop: company brand
    private String model; //prop: model name
    private String year; //prop: model year
    private String vin; //prop: vehicle identification number
    private Double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "VehicleDTO{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", vin='" + vin + '\'' +
                ", price=" + price +
                '}';
    }

    public VehicleDTO(String brand, String model, String year, String vin, Double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.vin = vin;
        this.price = price;
    }
}
