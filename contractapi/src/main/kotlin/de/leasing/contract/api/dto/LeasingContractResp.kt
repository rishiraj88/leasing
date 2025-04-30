package de.leasing.contract.api.dto

import java.time.LocalDateTime
import java.util.UUID

data class LeasingContractResp (
    //id for database integrity
    val id: UUID,
    //contractNumber for business use, may be rotated
    val contractNumber: String,
    val monthlyRate: Double,
    val vehicleIN: String,
    val customerName: String,
    val customerDto: CustomerDTO? = null,
    val vehicleDto: VehicleDTO? = null,
    val leaseStartsAt: LocalDateTime? = null,
    val leaseExpiresAt: LocalDateTime? = null
)
