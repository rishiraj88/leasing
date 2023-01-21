package allane.leasing.contract.service;

import allane.leasing.contract.entity.Vehicle;
import allane.leasing.contract.repo.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
