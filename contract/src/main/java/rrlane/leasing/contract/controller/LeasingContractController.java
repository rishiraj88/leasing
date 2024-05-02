package rrlane.leasing.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rrlane.leasing.contract.dto.LeasingContractDTO;
import rrlane.leasing.contract.entity.LeasingContract;
import rrlane.leasing.contract.service.LeasingContractService;
import rrlane.leasing.util.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contract")
public class LeasingContractController {
    @Autowired
    private LeasingContractService leasingContractService;
    private LeasingContract leasingContract = null;

    // to create a vehicle leasing contract with POST and also to edit contract details with PUT
    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PUT})
    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    public ResponseEntity<LeasingContractDTO> updateContract(@RequestBody LeasingContractDTO contractDTO) {
        HttpStatus status = HttpStatus.OK;
        if(null != contractDTO && -1 == contractDTO.getMonthlyRate()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (null == contractDTO.getCustomerName() || !contractDTO.getCustomerName().contains(" ")) {
            throw new IllegalArgumentException("Customer name [firstname and lastname both parts] must be entered.");
        }
        if (null == leasingContract) {
            leasingContract = new LeasingContract();
            status = HttpStatus.CREATED;
        }
        leasingContract.setContractNumber(contractDTO.getContractNumber());
        leasingContract.setMonthlyRate(contractDTO.getMonthlyRate());
        leasingContract.setCustomer(leasingContractService.getCustomerByName(contractDTO.getCustomerName()));
        leasingContract.setVehicle(leasingContractService.getVehicleByDetails(contractDTO.getVehicleDetails()));
        leasingContractService.saveLeasingContract(leasingContract);

        contractDTO = Mapper.entityToDto(leasingContract);
        return new ResponseEntity<>(contractDTO, HttpStatus.CREATED);
    }

    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    public ResponseEntity<List<LeasingContractDTO>> viewContract() {
        List<LeasingContract> leasingContracts = leasingContractService.view();
        if (null == leasingContracts || 0 == leasingContracts.size()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<LeasingContractDTO> leasingContractDTOs = leasingContracts.stream().map(Mapper::entityToDto).collect(Collectors.toList());

        return new ResponseEntity<>(leasingContractDTOs, HttpStatus.OK);
    }
}
