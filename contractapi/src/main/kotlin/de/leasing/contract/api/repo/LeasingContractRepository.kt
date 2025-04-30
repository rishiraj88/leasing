package de.leasing.contract.api.repo

import de.leasing.contract.api.entity.LeasingContract
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface LeasingContractRepository :JpaRepository<LeasingContract,UUID>{
}