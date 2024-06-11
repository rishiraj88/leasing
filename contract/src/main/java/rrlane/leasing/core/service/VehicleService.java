package rrlane.leasing.core.service;

import rrlane.leasing.contract.dto.VehicleDTO;
import rrlane.leasing.core.entity.Vehicle;
import java.util.List;

public interface VehicleService {
    public String saveVehicle(VehicleDTO vehicleDTO);

    public VehicleDTO searchForVehicle(VehicleDTO vehicleDTO);

    public List<Vehicle> getVehiclesByDetails(String[] details);
}
