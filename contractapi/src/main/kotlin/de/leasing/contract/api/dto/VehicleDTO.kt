package de.leasing.contract.api.dto

data class VehicleDTO(
    val brand: String, val model: String, val makeYear: String? = null, val vin: String,
    val price: Double? = null
)
