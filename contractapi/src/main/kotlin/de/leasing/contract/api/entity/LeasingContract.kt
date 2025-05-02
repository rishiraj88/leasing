package de.leasing.contract.api.entity

import de.leasing.contract.api.entity.dto.LeasingContractReq
import de.leasing.contract.api.entity.dto.LeasingContractResp
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "leasecontracts")
data class LeasingContract(
    @Column(name = "lcnum", length = 12) val contractNumber: String,
    @Column(name = "monthly_rate") val monthlyRate: Double,
    @Column(name = "vin", length = 12) val vehicleIN: String,
    @Column(name = "customer_name", length = 17) val customerName: String,
    @Column(name = "starts_at") val leaseStartsAt: LocalDateTime? = null,
    @Column(name = "expires_at") val leaseExpiresAt: LocalDateTime? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    lateinit var id: UUID

    fun toResp() = LeasingContractResp(
        id, contractNumber, monthlyRate, vehicleIN, customerName,leaseStartsAt,leaseExpiresAt
    )

    companion object {
        fun fromReq(req: LeasingContractReq): LeasingContract =
            LeasingContract(
                req.contractNumber, req.monthlyRate, req.vehicleIN, req.customerName
            )
    }
}
