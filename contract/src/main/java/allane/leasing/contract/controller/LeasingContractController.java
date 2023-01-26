package allane.leasing.contract.controller;

import allane.leasing.contract.entity.LeasingContract;
import allane.leasing.contract.entity.dto.LeasingContractDTO;
import allane.leasing.contract.service.LeasingContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contract")
public class LeasingContractController {
    @Autowired
    private LeasingContractService leasingContractService;

    private LeasingContract leasingContract = null;

    // to create a vehicle with POST
    // also, to save a vehicle upon editing details with PUT
    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PUT})
    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    public ResponseEntity<LeasingContract> addContract(@RequestBody LeasingContractDTO contractDTO) {
        HttpStatus status = HttpStatus.OK;
        if(null != contractDTO &&  -1 == contractDTO.getmRate()) {
            leasingContract = null;
            return new ResponseEntity<>(leasingContract, HttpStatus.OK);
        }
        if(null == contractDTO.getCustomer() || !contractDTO.getCustomer().contains(" ")) {
            throw new IllegalArgumentException("Customer name [firstname and lastname both parts] must be entered.");
        }
        if(null == leasingContract) {
            leasingContract = new LeasingContract();
            status = HttpStatus.CREATED;
        }

        leasingContract.setContractNumber(contractDTO.getContractNo());
        leasingContract.setMonthlyRate(contractDTO.getmRate());
        leasingContract.setCustomer(leasingContractService.getCustomerByName(contractDTO.getCustomer()));
        leasingContract.setVehicle(leasingContractService.getVehicleByDetails(contractDTO.getVehicle()));

        leasingContract = leasingContract;
        leasingContractService.saveLeasingContract(leasingContract);
        return new ResponseEntity<>(leasingContract, HttpStatus.CREATED);
    }
}
