package de.leasing.contract.api.entity.dto

import java.time.LocalDateTime

data class LeasingContractReq (
    val contractNumber: String,
    val monthlyRate: Double,
    val vehicleIN: String,
    val customerName: String,
    val leaseStartsAt: LocalDateTime? = null,
    val leaseExpiresAt: LocalDateTime? = null
)
