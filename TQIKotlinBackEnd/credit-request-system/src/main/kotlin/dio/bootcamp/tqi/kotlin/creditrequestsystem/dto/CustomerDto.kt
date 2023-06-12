package dio.bootcamp.tqi.kotlin.creditrequestsystem.dto

import dio.bootcamp.tqi.kotlin.creditrequestsystem.entity.Customer
import dio.bootcamp.tqi.kotlin.creditrequestsystem.entity.Address
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Email
import org.hibernate.validator.constraints.br.CPF

import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "Invalid iput") val firstName: String,
    @field:NotEmpty(message = "Invalid iput") val lastName: String,
    @field:CPF(message = "Invalid CPF") val cpf: String,
    @field:NotNull(message = "Invalid input") val income: BigDecimal,
    @field:Email(message = "Invalid email")
    @field:NotEmpty(message = "Invalid iput") val email: String,
    @field:NotEmpty(message = "Invalid iput") val password: String,
    @field:NotEmpty(message = "Invalid iput") val zipCode: String,
    @field:NotEmpty(message = "Invalid iput") val street: String
){
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}