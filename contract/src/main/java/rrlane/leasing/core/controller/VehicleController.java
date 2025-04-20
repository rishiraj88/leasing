package rrlane.leasing.core.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    // to create a vehicle with POST and also to edit vehicle details with PUT
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PATCH})
    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    public ResponseEntity<VehicleDTO> addVehicle(@RequestBody VehicleDTO vehicleDTO) throws ParseException {
        log.info("Sending vehicle details to server...");
        HttpStatus responseStatus = HttpStatus.OK;
        String responseFromService = vehicleService.saveVehicle(vehicleDTO);
        if (responseFromService.contains("created")) responseStatus = HttpStatus.CREATED;
        log.info(responseFromService);
        return new ResponseEntity<>(vehicleDTO, responseStatus);
    }

    // to retrieve the details of a vehicle with matching search criteria in specific order
    @GetMapping()
    public ResponseEntity<VehicleDTO> viewVehicle(@RequestBody VehicleDTO vehicleDTO) throws ParseException {
        log.info("Searching for vehicle details on server...");
        VehicleDTO retrievedVehicleDTO = vehicleService.searchForVehicle(vehicleDTO);
        if (null == retrievedVehicleDTO) {
            log.error("Vehicle details could not be found on server.");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        log.info("Found the vehicle details with VIN: " + retrievedVehicleDTO.getVin());
        return new ResponseEntity<>(retrievedVehicleDTO, HttpStatus.OK);
    }
}
