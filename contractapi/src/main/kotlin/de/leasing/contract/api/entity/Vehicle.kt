package de.leasing.contract.api.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "vehicles")
data class Vehicle(
    @Column(name = "brand", length = 12)
    val brand: String,
    @Column(name = "model", length = 12)
    val model: String,
    @Column(name = "make_year")
    val makeYear: String? = null,
    @Column(name = "vin", length = 12)
    val vin: String,
    @Column(name = "price", length = 12)
    val price: Double? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    lateinit var id: UUID
}