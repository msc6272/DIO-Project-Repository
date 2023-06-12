package dio.bootcamp.tqi.kotlin.creditrequestsystem.service

import dio.bootcamp.tqi.kotlin.creditrequestsystem.entity.Customer

interface ICustomerService {
    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long)
}