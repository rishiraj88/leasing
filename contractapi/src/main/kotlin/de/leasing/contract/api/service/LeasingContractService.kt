package de.leasing.contract.api.service

import de.leasing.contract.api.dto.LeasingContractReq
import de.leasing.contract.api.dto.LeasingContractResp

interface LeasingContractService {
    fun saveLeasingContract(contractReq: LeasingContractReq ): LeasingContractResp
}
