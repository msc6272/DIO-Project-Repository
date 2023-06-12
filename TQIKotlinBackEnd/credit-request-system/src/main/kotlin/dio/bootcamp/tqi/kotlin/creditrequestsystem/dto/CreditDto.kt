package dio.bootcamp.tqi.kotlin.creditrequestsystem.dto

import java.math.BigDecimal
import java.time.LocalDate
import dio.bootcamp.tqi.kotlin.creditrequestsystem.entity.Credit
import dio.bootcamp.tqi.kotlin.creditrequestsystem.entity.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Min

data class CreditDto(
    @field:NotNull(message = "Invalid input") val creditValue: BigDecimal,
    @field:Future val dayFirstOfInstallment: LocalDate,
    @field:Min(value = 1) val numberOfInstallments: Int,
    @field:NotNull(message = "Invalid input") val customerId: Long
){
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}