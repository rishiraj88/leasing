package de.leasing.contract.api.data

import de.leasing.contract.api.entity.LeasingContract
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface LeasingContractRepository :JpaRepository<LeasingContract,UUID>{
}