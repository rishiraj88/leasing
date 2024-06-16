package rrlane.leasing.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final VehicleService vehicleService;
    private final Logger logs = null;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
        logs = LoggerFactory.getLogger(VehicleController.class);
    }

    // to create a vehicle with POST and also to edit vehicle details with PUT
    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PATCH})
    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    public ResponseEntity<VehicleDTO> addVehicle(@RequestBody VehicleDTO vehicleDTO) throws ParseException {
        logs.info("Sending vehicle details to server...");
        HttpStatus responseStatus = HttpStatus.OK;
        String responseFromService = vehicleService.saveVehicle(vehicleDTO);
        if (responseFromService.contains("created")) responseStatus = HttpStatus.CREATED;
        logs.info(responseFromService);
        return new ResponseEntity<>(vehicleDTO, responseStatus);
    }

    // to retrieve the details of a vehicle with matching search criteria in specific order
    @GetMapping("/")
    public ResponseEntity<VehicleDTO> viewVehicle(@RequestBody VehicleDTO vehicleDTO) throws ParseException {
        logs.info("Searching for vehicle details on server...");
        VehicleDTO retrievedVehicleDTO = vehicleService.searchForVehicle(vehicleDTO);
        if (null == retrievedVehicleDTO) {
            logs.error("Vehicle details could not be found on server.");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        logs.info("Found the vehicle details with VIN: " + retrievedVehicleDTO.getVin());
        return new ResponseEntity<>(retrievedVehicleDTO, HttpStatus.OK);
    }
}
