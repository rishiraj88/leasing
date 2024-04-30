package rrlane.leasing.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rrlane.leasing.entity.Vehicle;
import rrlane.leasing.repo.VehicleRepository;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    @Transactional
    public void saveVehicle(Vehicle vehicle) {
        System.out.println("Saving vehicle...");
        vehicleRepository.save(vehicle);
        System.out.println("Saved vehicle successfully.");
    }

    public List<Vehicle> getVehiclesByDetails(String[] details){
        List<Vehicle> foundVehicles = null;
        foundVehicles = vehicleRepository.findByBrand(details[0]);
        if(null == foundVehicles)
        foundVehicles = vehicleRepository.findByModel(details[1]);
        if(null == foundVehicles)
        foundVehicles = vehicleRepository.findByModelYear(details[2]);
        if(null == foundVehicles)
        foundVehicles = vehicleRepository.findByVin(details[3]);
        return foundVehicles;
    }
}
