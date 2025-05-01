package de.leasing.contract.api.service

import de.leasing.contract.api.dto.CustomerReq
import de.leasing.contract.api.dto.CustomerResp
import de.leasing.contract.api.entity.Customer
import de.leasing.contract.api.exception.ResourceNotFoundException
import de.leasing.contract.api.repo.CustomerRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class CustomerServiceImpl(private val customerRepository: CustomerRepository) :
    CustomerService {

    private val log: Logger = LoggerFactory.getLogger(CustomerServiceImpl::class.java)

    override fun saveCustomerRecord(customerReq: CustomerReq): CustomerResp {
        log.info("Saving the details of vehicle customer...")
        return customerRepository.save(Customer.fromReq(customerReq)).toResp()
    }

    override fun listAllCustomerRecords(page: Int, size: Int): Iterable<CustomerResp> {
        val pageable: Pageable = PageRequest.of(page, size)
        val customerResps = customerRepository.findAll(pageable).map { it.toResp() }
        if (customerResps.isEmpty) throw ResourceNotFoundException("No records of customers found.")
        return customerResps
    }

    override fun listAllCustomerRecords(sortBy: String?): Iterable<CustomerResp> {
        val sortedCustomerResps = if (null == sortBy) customerRepository.findAll()
            .map { it.toResp() } else customerRepository.findAll(
            Sort.by(
                Sort.Direction.DESC, sortBy
            )
        ).map { it.toResp() }
        if (sortedCustomerResps.isEmpty()) throw ResourceNotFoundException("No customer records available to sort and present.")
        return sortedCustomerResps
    }
}