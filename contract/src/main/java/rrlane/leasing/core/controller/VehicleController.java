package rrlane.leasing.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rrlane.leasing.contract.dto.VehicleDTO;
import rrlane.leasing.core.service.VehicleService;

import java.text.ParseException;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // to create a vehicle with POST and also to edit vehicle details with PUT
    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PATCH})
    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    public ResponseEntity<VehicleDTO> addVehicle(@RequestBody VehicleDTO vehicleDTO) throws ParseException {
        HttpStatus responseStatus = HttpStatus.OK;
        String responseFromService = vehicleService.saveVehicle(vehicleDTO);
        if (responseFromService.contains("created")) responseStatus = HttpStatus.CREATED;
        return new ResponseEntity<>(vehicleDTO, responseStatus);
    }

    // to retrieve the details of a vehicle with matching search criteria in specific order
    @GetMapping("/")
    public ResponseEntity<VehicleDTO> viewCustomer(@RequestBody VehicleDTO vehicleDTO) throws ParseException {
        VehicleDTO retrievedVehicleDTO = vehicleService.searchForVehicle(vehicleDTO);
        if (null == retrievedVehicleDTO) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        System.out.println("Found the vehicle: " + retrievedVehicleDTO);
        return new ResponseEntity<>(retrievedVehicleDTO, HttpStatus.OK);
    }
}
