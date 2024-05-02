package rrlane.leasing.common.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rrlane.leasing.contract.dto.VehicleDTO;
import rrlane.leasing.entity.Vehicle;
import rrlane.leasing.service.VehicleService;
import rrlane.leasing.util.Mapper;

import java.text.ParseException;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    private Vehicle vehicle = null;

    // to create a vehicle with POST and also to edit vehicle details with PUT
    @RequestMapping(value = "/",method = {RequestMethod.POST, RequestMethod.PUT})
    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    public ResponseEntity<Vehicle> addVehicle(@RequestBody VehicleDTO vehicleDTO) throws ParseException {
        HttpStatus status = HttpStatus.OK;
        if(-1 == vehicleDTO.getPrice()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(null == vehicle) {
            vehicle = new Vehicle();
            status = HttpStatus.CREATED;
        }

        vehicle = Mapper.dtoToEntity(vehicleDTO);
        vehicleService.saveVehicle(vehicle);

        vehicleDTO = Mapper.entityToDto(vehicle);
        return new ResponseEntity<>(vehicle, status);
    }

}
