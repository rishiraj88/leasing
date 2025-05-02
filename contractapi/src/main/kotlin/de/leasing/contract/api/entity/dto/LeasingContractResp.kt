package de.leasing.contract.api.entity.dto

import java.time.LocalDateTime

data class LeasingContractResp (
    //id for database integrity
    val id: String,
    //contractNumber for business use, may be rotated
    val contractNumber: String,
    val monthlyRate: Double,
    val vehicleIN: String,
    val customerName: String,
    val leaseStartsAt: LocalDateTime? = null,
    val leaseExpiresAt: LocalDateTime? = null
)
