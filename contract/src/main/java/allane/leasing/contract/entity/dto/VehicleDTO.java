package allane.leasing.contract.entity.dto;

public class VehicleDTO {
    private String brand; //prop: company brand
    private String model; //prop: model name
    private String myear; //prop: model year
    private String vin; //prop: vehicle identification number
    private Double price; //prop

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

    public String getMyear() {
        return myear;
    }

    public void setMyear(String modelYear) {
        this.myear = modelYear;
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
                ", myear='" + myear + '\'' +
                ", vin='" + vin + '\'' +
                ", price=" + price +
                '}';
    }
}
