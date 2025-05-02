package de.leasing.contract.api.entity.dto

import java.time.LocalDate

data class CustomerResp (
    val id: String,
    val name: String,
    val birthDate: LocalDate
)
