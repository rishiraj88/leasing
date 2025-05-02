package de.leasing.contract.api.service

import de.leasing.contract.api.entity.dto.CustomerReq
import de.leasing.contract.api.entity.dto.CustomerResp

interface CustomerService {
    fun saveCustomerRecord(customerReq: CustomerReq): CustomerResp
    fun listAllCustomerRecords(page: Int, size: Int): Iterable<CustomerResp>
    fun listAllCustomerRecords(sortBy: String?): Iterable<CustomerResp>
    fun getCustomerById(id: String): CustomerResp
}
