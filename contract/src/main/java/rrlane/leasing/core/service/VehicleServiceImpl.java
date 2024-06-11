package rrlane.leasing.core.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rrlane.leasing.contract.dto.VehicleDTO;
import rrlane.leasing.core.Constants;
import rrlane.leasing.core.entity.Vehicle;
import rrlane.leasing.core.repo.VehicleRepository;
import rrlane.leasing.util.Mapper;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    @Transactional
    public String saveVehicle(VehicleDTO vehicleDTO) {
        System.out.println("Saving/Updating vehicle details...");
        String response = "";
        Vehicle vehicle = null;
        List<Vehicle> foundVehicles = vehicleRepository.findByBrandAndModelAndModelYear(vehicleDTO.getBrand(), vehicleDTO.getModel(), vehicleDTO.getMyear());
        if (!foundVehicles.isEmpty()) {
            vehicle = foundVehicles.get(0);
            vehicle.setVin(vehicleDTO.getVin());
            vehicle.setPrice(vehicleDTO.getPrice());
            vehicleRepository.save(vehicle);
            System.out.println(Constants.VEHICLE_UPDATED);
            return Constants.VEHICLE_UPDATED;
        }
        vehicle = Vehicle.builder().brand(vehicleDTO.getBrand()).model(vehicleDTO.getModel()).modelYear(vehicleDTO.getMyear()).vin(vehicleDTO.getVin()).price(vehicleDTO.getPrice()).build();
        vehicleRepository.save(vehicle);
        System.out.println(Constants.VEHICLE_ADDED);
        return Constants.VEHICLE_ADDED;
    }

    public VehicleDTO searchForVehicle(VehicleDTO vehicleDTO) {
        List<Vehicle> vehicleList = getVehicleEntities(vehicleDTO);
        if (null != vehicleList && 0 < vehicleList.size()) {
            System.out.println(Constants.VEHICLE_FOUND);
            return vehicleList.stream().map(Mapper::entityToDto).toList().get(0);
        }
        return null;
    }

    public List<Vehicle> getVehicleEntities(VehicleDTO vehicleDTO) {
        List<Vehicle> foundVehicles = null;
        foundVehicles = vehicleRepository.findByBrand(vehicleDTO.getBrand());
        if (null == foundVehicles) {
            foundVehicles = vehicleRepository.findByModel(vehicleDTO.getModel());
        }
        if (null == foundVehicles) {
            foundVehicles = vehicleRepository.findByModelYear(vehicleDTO.getMyear());
        }
        if (null == foundVehicles) {
            foundVehicles = vehicleRepository.findByVin(vehicleDTO.getVin());
        }
        return foundVehicles;
    }

    public List<Vehicle> getVehiclesByDetails(String[] details) {
        List<Vehicle> foundVehicles = null;
        foundVehicles = vehicleRepository.findByBrand(details[0]);
        if (null == foundVehicles) foundVehicles = vehicleRepository.findByModel(details[1]);
        if (null == foundVehicles) foundVehicles = vehicleRepository.findByModelYear(details[2]);
        if (null == foundVehicles) foundVehicles = vehicleRepository.findByVin(details[3]);
        return foundVehicles;
    }
}
