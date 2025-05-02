package de.leasing.contract.api.service

import de.leasing.contract.api.entity.dto.LeasingContractReq
import de.leasing.contract.api.entity.dto.LeasingContractResp
import de.leasing.contract.api.entity.LeasingContract
import de.leasing.contract.api.exception.ResourceNotFoundException
import de.leasing.contract.api.repo.LeasingContractRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.*

@Service
class LeasingContractServiceImpl(private val leasingContractRepository: LeasingContractRepository) :
    LeasingContractService {
    private val log: Logger = LoggerFactory.getLogger(LeasingContractServiceImpl::class.java)

    override fun saveLeasingContract(contractReq: LeasingContractReq): LeasingContractResp {
        log.info("Saving the details of vehicle-lease contract...")
        return leasingContractRepository.save(LeasingContract.fromReq(contractReq)).toResp()
    }

    override fun listAllLeasingContracts(page: Int, size: Int): Iterable<LeasingContractResp> {
        val pageable: Pageable = PageRequest.of(page, size)
        val leasingContractResps = leasingContractRepository.findAll(pageable).map { it.toResp() }
        if (leasingContractResps.isEmpty) throw ResourceNotFoundException("No records of leasing contracts found.")
        return leasingContractResps
    }

    override fun listAllLeasingContracts(sortBy: String?): Iterable<LeasingContractResp> {
        val sortedLeasingContractResps = if (null == sortBy) leasingContractRepository.findAll()
            .map { it.toResp() } else leasingContractRepository.findAll(
            Sort.by(
                Sort.Direction.DESC, sortBy
            )
        ).map { it.toResp() }
        if (sortedLeasingContractResps.isEmpty()) throw ResourceNotFoundException("No leasing contracts available to sort and present.")
        return sortedLeasingContractResps
    }

    override fun getLeasingContractById(id: UUID): LeasingContractResp {
        return leasingContractRepository.getById(id).toResp()
    }
}