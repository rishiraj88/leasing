package de.leasing.contract.api.entity.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class LeasingContractReq (
    val contractNumber: String,
    val monthlyRate: Double,
    val vehicleIN: String,
    val customerName: String,
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy. MM. dd.'T'HH:mm:ss") val leaseStartsAt: LocalDateTime? = null,
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy. MM. dd.'T'HH:mm:ss") val leaseExpiresAt: LocalDateTime? = null
)
