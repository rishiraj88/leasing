package rrlane.leasing.service;


import rrlane.leasing.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    public void saveVehicle(Vehicle vehicle);
    public List<Vehicle> getVehiclesByDetails(String[] details);
}
