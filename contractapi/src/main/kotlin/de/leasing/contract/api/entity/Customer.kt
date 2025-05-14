package de.leasing.contract.api.entity

import de.leasing.contract.api.entity.dto.CustomerReq
import de.leasing.contract.api.entity.dto.CustomerResp
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDate

@Entity
@Table(name = "customers")
data class Customer(
    @Column(name = "name", length = 17)
    val name: String,
    @Column(name = "birth_date") @Temporal(TemporalType.DATE)
    val birthDate: LocalDate
/*
, onetomany(mappedBy="customer")
List<Contract> contracts
 */
) {

    @Id
    @UuidGenerator
    lateinit var id: String

    fun toResp() = CustomerResp(id,name,birthDate)

    companion object {
        fun fromReq(req: CustomerReq): Customer =
            Customer(req.name, req.birthDate)
    }


}