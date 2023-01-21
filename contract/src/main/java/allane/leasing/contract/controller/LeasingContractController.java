package allane.leasing.contract.controller;

import allane.leasing.contract.entity.LeasingContract;
import allane.leasing.contract.service.LeasingContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contract")
public class LeasingContractController {
    @Autowired
    private LeasingContractService leasingContractService;

    private LeasingContract leasingContract = null;

    // to create a leasing contract
    @PostMapping("/")
    public ResponseEntity<LeasingContract>
    addContract(@RequestBody LeasingContract contract) {
        leasingContract = contract;
        leasingContractService.saveLeasingContract(leasingContract);
        return new ResponseEntity<>(leasingContract, HttpStatus.CREATED);
    }
}
