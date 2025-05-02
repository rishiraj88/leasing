package de.leasing.contract.api.repo

import de.leasing.contract.api.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository :JpaRepository<Customer,String>{
}