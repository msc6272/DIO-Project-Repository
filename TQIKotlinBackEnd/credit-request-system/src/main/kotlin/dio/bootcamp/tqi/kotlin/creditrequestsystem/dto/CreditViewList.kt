package dio.bootcamp.tqi.kotlin.creditrequestsystem.dto

import java.math.BigDecimal
import java.util.UUID
import dio.bootcamp.tqi.kotlin.creditrequestsystem.entity.Credit

data class CreditViewList(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallments: Int
) {
    constructor(credit: Credit): this (
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallments = credit.numberOfInstallments
    )
}