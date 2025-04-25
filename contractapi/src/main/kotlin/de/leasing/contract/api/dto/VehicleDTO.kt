package de.leasing.contract.api.dto

data class VehicleDTO(
    val brand: String, val model: String, val myear: String? = null, val vin: String,
    val price: Double? = null
)
