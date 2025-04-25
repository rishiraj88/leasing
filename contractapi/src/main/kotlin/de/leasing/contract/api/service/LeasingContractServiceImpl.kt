package de.leasing.contract.api.service

import de.leasing.contract.api.data.LeasingContractRepository
import de.leasing.contract.api.dto.LeasingContractReq
import de.leasing.contract.api.dto.LeasingContractResp
import de.leasing.contract.api.entity.LeasingContract
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class LeasingContractServiceImpl(val leasingContractRepository: LeasingContractRepository) :LeasingContractService{
    private val log: Logger = LoggerFactory.getLogger(LeasingContractServiceImpl::class.java)

    override fun saveLeasingContract(contractReq: LeasingContractReq): LeasingContractResp {
        log.info("Saving the details of the lease contract...")
        return leasingContractRepository.save(LeasingContract.fromReq(contractReq)).toResp()
    }
}