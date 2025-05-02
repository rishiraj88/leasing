package de.leasing.contract.api.entity.dto

import java.time.LocalDate

data class CustomerReq (
    val name: String,
    val birthDate: LocalDate
)
