package de.leasing.contract.api.entity

import de.leasing.contract.api.entity.dto.VehicleReq
import de.leasing.contract.api.entity.dto.VehicleResp
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.UuidGenerator

@Entity
@Table(name = "vehicles")
data class Vehicle(
    @Column(name = "brand", length = 12)
    val brand: String,
    @Column(name = "model", length = 12)
    val model: String,
    @Column(name = "make_year", length = 4)
    val makeYear: String? = null,
    @Column(name = "vin", length = 12)
    val vin: String,
    @Column(name = "price", length = 12)
    val price: Double? = null
) {
    @Id
    @UuidGenerator
    lateinit var id: String

    fun toResp() = VehicleResp(id,brand, model, makeYear, vin, price)

    companion object {
        fun fromReq(req: VehicleReq):Vehicle =
            Vehicle(req.brand, req.model, req.makeYear, req.vin, req.price)
    }

}