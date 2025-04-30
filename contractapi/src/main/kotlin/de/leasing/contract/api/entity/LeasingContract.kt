package de.leasing.contract.api.entity

import de.leasing.contract.api.dto.CustomerDTO
import de.leasing.contract.api.dto.LeasingContractReq
import de.leasing.contract.api.dto.LeasingContractResp
import de.leasing.contract.api.dto.VehicleDTO
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "leasecontracts")
data class LeasingContract(
    @Column(name = "lcnum") val contractNumber: String,
    @Column(name = "monthly_rate") val monthlyRate: Double,
    @Column(name = "vin") val vehicleIN: String,
    @Column(name = "customer_name") val customerName: String,
    val customerDto: CustomerDTO? = null,
    val vehicleDto: VehicleDTO? = null,
    val leaseStartsAt: LocalDateTime? = null,
    val leaseExpiresAt: LocalDateTime? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    lateinit var id: UUID

    fun toResp() = LeasingContractResp(
        id, contractNumber, monthlyRate, vehicleIN, customerName, customerDto,
        vehicleDto
    )

    companion object {
        fun fromReq(req: LeasingContractReq): LeasingContract =
            LeasingContract(
                req.contractNumber, req.monthlyRate, req.vehicleIN, req.customerName, req.customerDto,
                req.vehicleDto
            )
    }
}
