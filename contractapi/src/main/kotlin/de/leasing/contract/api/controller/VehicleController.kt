package de.leasing.contract.api.controller

import de.leasing.contract.api.commons.Constants
import de.leasing.contract.api.entity.dto.VehicleReq
import de.leasing.contract.api.entity.dto.VehicleResp
import de.leasing.contract.api.service.VehicleService
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

@RestController @RequestMapping("/api/v2/vehicles/")
@Slf4j
class VehicleController(private val vehicleService: VehicleService) {
    private val log: Logger = LoggerFactory.getLogger(VehicleController::class.java)

    @PostMapping
    fun addVehicle(
        @RequestBody vehicleReq: VehicleReq,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<VehicleResp> {
        log.info("saving vehicle details on server...")
        val newVehicleRecord:VehicleResp = vehicleService.saveVehicleRecord(vehicleReq)
        log.info(Constants.VEHICLE_CREATED)

        val location = uriBuilder.path("/api/v2/vehicles/{id}")
            .buildAndExpand(newVehicleRecord.id).toUri()
        return ResponseEntity.created(location).body(newVehicleRecord)
    }

    @GetMapping("{id}")
    fun viewVehicleById(
        @PathVariable id: UUID
    ) : ResponseEntity<VehicleResp>{
        log.info("Fetching the vehicle record with the input ID...")
        return ResponseEntity.ok(vehicleService.getVehicleById(id))
    }

    @GetMapping
    fun viewAllVehicles(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "20") size: Int,
        @RequestParam(required = false) sortBy: String?
    ) : ResponseEntity<Iterable<VehicleResp>>{
        log.info("Fetching the list of all the vehicles...")
        return  if (null == sortBy) ResponseEntity.ok(vehicleService.listAllVehicleRecords(page, size))
        else ResponseEntity.ok(vehicleService.listAllVehicleRecords(sortBy))
    }
}