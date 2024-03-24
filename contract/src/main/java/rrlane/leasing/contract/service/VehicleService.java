package rrlane.leasing.contract.service;

import rrlane.leasing.contract.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    public void saveVehicle(Vehicle vehicle);
    public List<Vehicle> getVehiclesByDetails(String[] details);
}
