package de.leasing.contract.api.repo

import de.leasing.contract.api.entity.Vehicle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VehicleRepository :JpaRepository<Vehicle,String>{
}