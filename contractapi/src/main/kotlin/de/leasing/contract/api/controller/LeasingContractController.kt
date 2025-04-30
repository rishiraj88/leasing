package de.leasing.contract.api.controller

import de.leasing.contract.api.commons.Constants
import de.leasing.contract.api.dto.LeasingContractReq
import de.leasing.contract.api.dto.LeasingContractResp
import de.leasing.contract.api.service.LeasingContractService
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController("/api/v2/contracts")
@Slf4j
class LeasingContractController(private val leasingContractService: LeasingContractService) {
    private val log: Logger = LoggerFactory.getLogger(LeasingContractController::class.java)

    @PostMapping
    fun createContract(
        @RequestBody leasingContractReq: LeasingContractReq,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<LeasingContractResp> {
        log.info("Uploading contract details to server...")
        val newLeasingContract: LeasingContractResp = leasingContractService.saveLeasingContract(leasingContractReq)
        log.info(Constants.LEASING_CONTRACT_CREATED)

        val location = uriBuilder.path("/api/v2/contracts/{id}")
            .buildAndExpand(newLeasingContract.id).toUri()
        return ResponseEntity.created(location).body(newLeasingContract)
    }
}