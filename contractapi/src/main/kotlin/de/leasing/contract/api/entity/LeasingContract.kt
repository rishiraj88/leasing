package de.leasing.contract.api.entity

import de.leasing.contract.api.entity.dto.LeasingContractReq
import de.leasing.contract.api.entity.dto.LeasingContractResp
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDateTime

@Entity
@Table(name = "leasecontracts")
data class LeasingContract(
    @Column(name = "lcnum", length = 12) val contractNumber: String,
    @Column(name = "monthly_rate") val monthlyRate: Double,
    @Column(name = "vin", length = 12) val vehicleIN: String,
    @Column(name = "customer_name", length = 17) val customerName: String,
    @Column(name = "starts_at") @Temporal(TemporalType.TIMESTAMP) val leaseStartsAt: LocalDateTime? = null,
    @Column(name = "expires_at") @Temporal(TemporalType.TIMESTAMP) val leaseExpiresAt: LocalDateTime? = null
) {
    @Id
    @UuidGenerator
    lateinit var id: String

    fun toResp() = LeasingContractResp(
        id, contractNumber, monthlyRate, vehicleIN, customerName,leaseStartsAt,leaseExpiresAt
    )

    companion object {
        fun fromReq(req: LeasingContractReq): LeasingContract {
            return LeasingContract(
                req.contractNumber, req.monthlyRate, req.vehicleIN, req.customerName,req.leaseStartsAt,req.leaseExpiresAt
            )
        }
    }

}
