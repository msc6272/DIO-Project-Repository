package dio.bootcamp.tqi.kotlin.creditrequestsystem.dto

import java.math.BigDecimal
import dio.bootcamp.tqi.kotlin.creditrequestsystem.entity.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class CustomerUpdateDto(
    @field:NotEmpty(message = "Invalid iput") val firstName: String,
    @field:NotEmpty(message = "Invalid iput") val lastName: String,
    @field:NotNull(message = "Invalid input") val income: BigDecimal,
    @field:NotEmpty(message = "Invalid iput") val zipCode: String,
    @field:NotEmpty(message = "Invalid iput") val street: String
){
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.street
        customer.address.zipCode = this.zipCode
        return customer
    }
}