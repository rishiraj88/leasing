package de.leasing.contract.api.entity

import de.leasing.contract.api.dto.CustomerReq
import de.leasing.contract.api.dto.CustomerResp
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "customers")
data class Customer(val name: String, val birthDate: LocalDate) {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    lateinit var id: UUID


    fun toResp() = CustomerResp(id,name,birthDate)

    companion object {
        fun fromReq(req: CustomerReq): Customer =
            Customer(req.name, req.birthDate)
    }
}