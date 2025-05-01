package de.leasing.contract.api.dto

import java.time.LocalDate
import java.util.UUID

data class CustomerResp (
    val id: UUID,
    val name: String,
    val birthDate: LocalDate
)
