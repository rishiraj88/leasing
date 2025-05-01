package de.leasing.contract.api.repo

import de.leasing.contract.api.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CustomerRepository :JpaRepository<Customer,UUID>{
}