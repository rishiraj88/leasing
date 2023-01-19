package allane.leasing.contract.controller;

import allane.leasing.contract.entity.Vehicle;
import allane.leasing.contract.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    private Vehicle vehicle = null;

    // to create a vehicle
    @PostMapping("/")
    public ResponseEntity<Vehicle> addVehicle(@RequestParam String brand, @RequestParam String model, @RequestParam String year, @RequestParam String vin, @RequestParam Double price) throws ParseException {
        vehicle = new Vehicle();
        vehicle.setBrand(brand);
        vehicle.setModel(model);
        vehicle.setModelYear(year);
        vehicle.setVin(vin);
        vehicle.setPrice(price);

        vehicleService.saveVehicle(vehicle);
        return new ResponseEntity<>(vehicle, HttpStatus.CREATED);
    }

}
