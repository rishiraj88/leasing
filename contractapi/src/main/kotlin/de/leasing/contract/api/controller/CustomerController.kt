package de.leasing.contract.api.controller

import de.leasing.contract.api.commons.Constants
import de.leasing.contract.api.entity.dto.CustomerReq
import de.leasing.contract.api.entity.dto.CustomerResp
import de.leasing.contract.api.service.CustomerService
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import java.util.UUID

@RestController @RequestMapping("/api/v2/customers/")
@Slf4j
class CustomerController(private val customerService: CustomerService) {
    private val log: Logger = LoggerFactory.getLogger(CustomerController::class.java)

    @PostMapping
    fun addCustomer(
        @RequestBody customerReq: CustomerReq,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CustomerResp> {
        log.info("saving customer details on server...")
        val newCustomerRecord: CustomerResp = customerService.saveCustomerRecord(customerReq)
        log.info(Constants.CUSTOMER_CREATED)

        val location = uriBuilder.path("/api/v2/customers/{id}")
            .buildAndExpand(newCustomerRecord.id).toUri()
        return ResponseEntity.created(location).body(newCustomerRecord)
    }

    @GetMapping("{id}")
    fun viewCustomerById(
        @PathVariable id: UUID
    ) : ResponseEntity<CustomerResp>{
        log.info("Fetching the customer record with the input ID...")
        return ResponseEntity.ok(customerService.getCustomerById(id))
    }

    @GetMapping
    fun viewAllCustomers(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "20") size: Int,
        @RequestParam(required = false) sortBy: String?
    ) : ResponseEntity<Iterable<CustomerResp>>{
        log.info("Fetching the list of all the customers...")
        return  if (null == sortBy) ResponseEntity.ok(customerService.listAllCustomerRecords(page, size))
        else ResponseEntity.ok(customerService.listAllCustomerRecords(sortBy))
    }
}