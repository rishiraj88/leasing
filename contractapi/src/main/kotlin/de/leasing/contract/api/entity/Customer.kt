package de.leasing.contract.api.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "customers")
data class Customer(val name: String, val birthDate: LocalDate) {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    lateinit var id: UUID

}