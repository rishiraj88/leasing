package de.leasing.contract.api.entity

import de.leasing.contract.api.dto.CustomerDTO
import de.leasing.contract.api.dto.LeasingContractReq
import de.leasing.contract.api.dto.LeasingContractResp
import de.leasing.contract.api.dto.VehicleDTO
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import java.util.*

@Entity
data class LeasingContract(
    val contractNumber: String,
    val monthlyRate: Double,
    val vehicleDetails: String,
    val customerName: String,
    val customerDto: CustomerDTO? = null,
    val vehicleDto: VehicleDTO? = null,
    val leaseStartsAt: LocalDateTime? = null,
    val leaseExpiresAt: LocalDateTime? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    lateinit var id: UUID

    fun toResp() = LeasingContractResp(
        id, contractNumber, monthlyRate, vehicleDetails, customerName, customerDto,
        vehicleDto
    )

    companion object {
        fun fromReq(req: LeasingContractReq): LeasingContract =
            LeasingContract(req.contractNumber,req. monthlyRate, req.vehicleDetails,req. customerName,req. customerDto,
                req.vehicleDto)
    }
}
