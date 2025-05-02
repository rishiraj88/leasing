package de.leasing.contract.api.service

import de.leasing.contract.api.entity.Vehicle
import de.leasing.contract.api.entity.dto.VehicleReq
import de.leasing.contract.api.entity.dto.VehicleResp
import de.leasing.contract.api.exception.ResourceNotFoundException
import de.leasing.contract.api.repo.VehicleRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class VehicleServiceImpl(private val vehicleRepository: VehicleRepository) :
    VehicleService {

    private val log: Logger = LoggerFactory.getLogger(VehicleServiceImpl::class.java)

    override fun saveVehicleRecord(vehicleReq: VehicleReq): VehicleResp {
        log.info("Saving the details of vehicle...")
        return vehicleRepository.save(Vehicle.fromReq(vehicleReq)).toResp()
    }

    override fun listAllVehicleRecords(page: Int, size: Int): Iterable<VehicleResp> {
        val pageable: Pageable = PageRequest.of(page, size)
        val vehicleResps = vehicleRepository.findAll(pageable).map { it.toResp() }
        if (vehicleResps.isEmpty()) throw ResourceNotFoundException("No records of vehicles found.")
        for(v in vehicleResps){
            print("vehicleResps: $v")}
        return vehicleResps
    }

    override fun listAllVehicleRecords(sortBy: String?): Iterable<VehicleResp> {
        val sortedVehicleResps = if (null == sortBy) vehicleRepository.findAll()
            .map { it.toResp() } else vehicleRepository.findAll(
            Sort.by(
                Sort.Direction.DESC, sortBy
            )
        ).map { it.toResp() }
        if (sortedVehicleResps.isEmpty()) throw ResourceNotFoundException("No vehicle records available to sort and present.")
        return sortedVehicleResps
    }

    override fun getVehicleById(id: String): VehicleResp {
        return vehicleRepository.getReferenceById(id).toResp()
    }

}