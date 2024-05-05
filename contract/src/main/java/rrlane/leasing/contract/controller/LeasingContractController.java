package rrlane.leasing.contract.controller;

import lombok.RequiredArgsConstructor;
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

@RequiredArgsConstructor
@RestController
@RequestMapping("/contract")
public class LeasingContractController {
    private LeasingContractService leasingContractService;
    private LeasingContract leasingContract = null;

    // to create a vehicle leasing contract with POST and also to edit contract details with PUT
    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PUT})
    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    public ResponseEntity<LeasingContractDTO> updateContract(@RequestBody LeasingContractDTO contractDTO) {
        HttpStatus responseStatus = HttpStatus.OK;
        String responseFromService = leasingContractService.saveLeasingContract(contractDTO);
        if (responseFromService.contains("created")) responseStatus = HttpStatus.CREATED;
        return new ResponseEntity<>(contractDTO, responseStatus);
    }

    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    public ResponseEntity<List<LeasingContractDTO>> viewContract() {
        List<LeasingContract> leasingContracts = leasingContractService.view();
        if (null == leasingContracts || 0 == leasingContracts.size()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<LeasingContractDTO> leasingContractDTOs = leasingContracts.stream().map(Mapper::entityToDto).toList();
        return new ResponseEntity<>(leasingContractDTOs, HttpStatus.OK);
    }
}
