package rrlane.leasing.contract.controller;

import rrlane.leasing.contract.entity.LeasingContract;
import rrlane.leasing.contract.entity.dto.LeasingContractDTO;
import rrlane.leasing.contract.service.LeasingContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<LeasingContract> updateContract(@RequestBody LeasingContractDTO contractDTO) {
        HttpStatus status = HttpStatus.OK;
        if (null != contractDTO && -1 == contractDTO.getMonthlyRate()) {
            leasingContract = null;
            return new ResponseEntity<>(leasingContract, HttpStatus.OK);
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

        leasingContract = leasingContract;
        leasingContractService.saveLeasingContract(leasingContract);
        return new ResponseEntity<>(leasingContract, HttpStatus.CREATED);
    }

    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    public ResponseEntity<LeasingContractDTO[]> view() {
        List<LeasingContract> leasingContracts =
                leasingContractService.view();
        if (null == leasingContracts || 0 == leasingContracts.size()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        LeasingContractDTO[] leasingContractDtos = new LeasingContractDTO[leasingContracts.size()];
        for (int i = 0; i < leasingContracts.size(); i++) {
            LeasingContract contract = leasingContracts.get(i);
            LeasingContractDTO contractDto = new LeasingContractDTO(contract.getContractNumber(),
                    contract.getMonthlyRate(), contract.getVehicle().getDetails(), contract.getCustomer().getName(), contract.getCustomer().getDto(), contract.getVehicle().getDto());
            leasingContractDtos[i] = contractDto;
        }
        return new ResponseEntity<>(leasingContractDtos, HttpStatus.OK);
    }

}
