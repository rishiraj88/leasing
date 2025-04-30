package de.leasing.contract.api.service

import de.leasing.contract.api.dto.LeasingContractReq
import de.leasing.contract.api.dto.LeasingContractResp
import de.leasing.contract.api.entity.LeasingContract
import de.leasing.contract.api.repo.LeasingContractRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class LeasingContractServiceImpl(private val leasingContractRepository: LeasingContractRepository) :LeasingContractService{
    private val log: Logger = LoggerFactory.getLogger(LeasingContractServiceImpl::class.java)

    override fun saveLeasingContract(contractReq: LeasingContractReq): LeasingContractResp {
        log.info("Saving the details of vehicle-lease contract...")
        return leasingContractRepository.save(LeasingContract.fromReq(contractReq)).toResp()
    }
}