package rrlane.leasing.contract.controller;

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
import rrlane.leasing.contract.dto.LeasingContractDTO;
import rrlane.leasing.contract.entity.LeasingContract;
import rrlane.leasing.contract.service.LeasingContractService;
import rrlane.leasing.util.Mapper;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class LeasingContractController {
    final Logger logs;
    private final LeasingContractService leasingContractService;

    public LeasingContractController(LeasingContractService leasingContractService) {
        this.leasingContractService = leasingContractService;
        logs = LoggerFactory.getLogger(LeasingContractController.class);
    }

    // to create a vehicle leasing contract with POST and also to edit contract details with PATCH
    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PATCH})
    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    public ResponseEntity<LeasingContractDTO> updateContract(@RequestBody LeasingContractDTO contractDTO) {
        logs.info("Sending contract details to server...");
        HttpStatus responseStatus = HttpStatus.OK;
        String responseFromService = leasingContractService.saveLeasingContract(contractDTO);
        if (responseFromService.contains("created")) responseStatus = HttpStatus.CREATED;
        logs.info(responseFromService);
        return new ResponseEntity<>(contractDTO, responseStatus);
    }

    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    public ResponseEntity<List<LeasingContractDTO>> viewContract() {
        logs.info("Searching for policy contract on server...");
        List<LeasingContract> leasingContracts = leasingContractService.view();
        if (null == leasingContracts || 0 == leasingContracts.size()) {
            logs.error("Policy contract could not be found on server.");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        List<LeasingContractDTO> leasingContractDTOs = leasingContracts.stream().map(Mapper::entityToDto).toList();
        logs.info("Found the contract details successfully in your name: " + leasingContractDTOs.get(0).getCustomerName());
        return new ResponseEntity<>(leasingContractDTOs, HttpStatus.OK);
    }
}
