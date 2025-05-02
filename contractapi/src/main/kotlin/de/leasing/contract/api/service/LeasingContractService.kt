package de.leasing.contract.api.service

import de.leasing.contract.api.entity.dto.LeasingContractReq
import de.leasing.contract.api.entity.dto.LeasingContractResp

interface LeasingContractService {
    fun saveLeasingContract(contractReq: LeasingContractReq): LeasingContractResp
    fun listAllLeasingContracts(page: Int, size: Int): Iterable<LeasingContractResp>
    fun listAllLeasingContracts(sortBy: String?): Iterable<LeasingContractResp>
    fun getLeasingContractById(id: String): LeasingContractResp
}
