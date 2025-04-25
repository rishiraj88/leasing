package de.leasing.contract.api.dto

import java.time.LocalDateTime

data class LeasingContractReq (
    val contractNumber: String,
    val monthlyRate: Double,
    val vehicleDetails: String,
    val customerName: String,
    val customerDto: CustomerDTO? = null,
    val vehicleDto: VehicleDTO? = null,
    val leaseStartsAt: LocalDateTime? = null,
    val leaseExpiresAt: LocalDateTime? = null
)
