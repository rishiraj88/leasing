package allane.leasing.contract.service;

import allane.leasing.contract.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    public void saveVehicle(Vehicle vehicle);
    public List<Vehicle> getVehiclesByDetails(String[] details);
}
