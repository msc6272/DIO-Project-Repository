package dio.bootcamp.tqi.kotlin.creditrequestsystem.service.impl

import java.lang.RuntimeException
import dio.bootcamp.tqi.kotlin.creditrequestsystem.entity.Customer
import dio.bootcamp.tqi.kotlin.creditrequestsystem.repository.CustomerRepository
import dio.bootcamp.tqi.kotlin.creditrequestsystem.service.ICustomerService
import dio.bootcamp.tqi.kotlin.creditrequestsystem.exception.BusinessException
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository): ICustomerService {
    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)

    override fun findById(id: Long): Customer = this.customerRepository.findById(id)
        .orElseThrow{ throw BusinessException("Id $id not found.") }

    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }
}