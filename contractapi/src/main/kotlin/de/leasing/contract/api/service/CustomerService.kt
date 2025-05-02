package de.leasing.contract.api.service

import de.leasing.contract.api.entity.dto.CustomerReq
import de.leasing.contract.api.entity.dto.CustomerResp
import de.leasing.contract.api.entity.dto.LeasingContractResp
import java.util.*

interface CustomerService {
    fun saveCustomerRecord(customerReq: CustomerReq): CustomerResp
    fun listAllCustomerRecords(page: Int, size: Int): Iterable<CustomerResp>
    fun listAllCustomerRecords(sortBy: String?): Iterable<CustomerResp>
    fun getCustomerById(id: UUID): CustomerResp
}
