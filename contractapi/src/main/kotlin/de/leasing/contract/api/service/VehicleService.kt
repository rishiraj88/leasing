package de.leasing.contract.api.service

import de.leasing.contract.api.entity.dto.VehicleReq
import de.leasing.contract.api.entity.dto.VehicleResp

interface VehicleService {
    fun saveVehicleRecord(customerReq: VehicleReq): VehicleResp
    fun listAllVehicleRecords(page: Int, size: Int): Iterable<VehicleResp>
    fun listAllVehicleRecords(sortBy: String?): Iterable<VehicleResp>
    fun getVehicleById(id: String): VehicleResp
}
