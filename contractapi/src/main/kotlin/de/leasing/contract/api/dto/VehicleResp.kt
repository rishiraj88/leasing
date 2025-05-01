package de.leasing.contract.api.dto
import java.util.UUID

data class VehicleResp(
    val id: UUID,
    val brand: String, val model: String, val makeYear: String? = null, val vin: String,
    val price: Double? = null
)
