package dio.bootcamp.tqi.kotlin.creditrequestsystem.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import dio.bootcamp.tqi.kotlin.creditrequestsystem.entity.Customer

@Repository
interface CustomerRepository: JpaRepository<Customer, Long>