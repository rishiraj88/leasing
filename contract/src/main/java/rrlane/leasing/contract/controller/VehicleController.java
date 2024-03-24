package rrlane.leasing.contract.controller;

import rrlane.leasing.contract.entity.Vehicle;
import rrlane.leasing.contract.entity.dto.VehicleDTO;
import rrlane.leasing.contract.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    private Vehicle vehicle = null;

    // to create a vehicle with POST
    // also, to save a vehicle upon editing details with PUT
    @RequestMapping(value = "/",method = {RequestMethod.POST, RequestMethod.PUT})
    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    public ResponseEntity<Vehicle> addVehicle(@RequestBody VehicleDTO vehicleDTO) throws ParseException {
        HttpStatus status = HttpStatus.OK;
        if(-1 == vehicleDTO.getPrice()) {
            vehicle = null;
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        }
        if(null == vehicle) {
            vehicle = new Vehicle();
            status = HttpStatus.CREATED;
        }
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setModelYear(vehicleDTO.getYear());
        vehicle.setVin(vehicleDTO.getVin());
        vehicle.setPrice(vehicleDTO.getPrice());

        vehicleService.saveVehicle(vehicle);
        return new ResponseEntity<>(vehicle, status);
    }

}
