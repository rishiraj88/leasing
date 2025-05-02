package de.leasing.contract.api.entity.dto

data class VehicleReq(
    val brand: String, val model: String, val makeYear: String? = null, val vin: String,
    val price: Double? = null
)
