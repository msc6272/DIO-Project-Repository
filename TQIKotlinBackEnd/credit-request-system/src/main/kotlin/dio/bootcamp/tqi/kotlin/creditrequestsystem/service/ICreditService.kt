package dio.bootcamp.tqi.kotlin.creditrequestsystem.service

import dio.bootcamp.tqi.kotlin.creditrequestsystem.entity.Credit
import java.util.UUID

interface ICreditService {
    fun save(credit: Credit): Credit

    fun findAllByCustomer(customerId: Long): List<Credit>

    fun findByCreditCode(customerId: Long, creditCode: UUID): Credit
}