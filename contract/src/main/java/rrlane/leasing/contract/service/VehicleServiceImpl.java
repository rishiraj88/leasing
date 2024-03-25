package rrlane.leasing.contract.service;

import rrlane.leasing.contract.entity.Vehicle;
import rrlane.leasing.contract.repo.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

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