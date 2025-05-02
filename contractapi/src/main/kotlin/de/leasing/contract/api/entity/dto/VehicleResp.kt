package de.leasing.contract.api.entity.dto

data class VehicleResp(
    val id: String,
    val brand: String, val model: String, val makeYear: String? = null, val vin: String,
    val price: Double? = null
)
