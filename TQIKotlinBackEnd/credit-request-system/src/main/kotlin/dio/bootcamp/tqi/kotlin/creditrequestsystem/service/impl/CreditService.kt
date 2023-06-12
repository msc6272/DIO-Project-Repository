package dio.bootcamp.tqi.kotlin.creditrequestsystem.service.impl

// import java.lang.RuntimeException
import java.util.UUID
import dio.bootcamp.tqi.kotlin.creditrequestsystem.entity.Credit
import dio.bootcamp.tqi.kotlin.creditrequestsystem.repository.CreditRepository
import dio.bootcamp.tqi.kotlin.creditrequestsystem.service.ICreditService
import dio.bootcamp.tqi.kotlin.creditrequestsystem.exception.BusinessException
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.time.LocalDate

@Service
class CreditService(private val creditRepository: CreditRepository, private val customerService: CustomerService): ICreditService {
    override fun save(credit: Credit): Credit {
        this.validDayFirstInstallment(credit.dayFirstInstallment)
        // System.out.println("Entrei no Credit Service -> save")
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> = 
        this.creditRepository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode) 
            ?: throw BusinessException("Creditcode $creditCode not found."))
        return if (credit.customer?.id == customerId) credit else throw IllegalArgumentException("Contact admin")
    }

    private fun validDayFirstInstallment(dayFirstInstallment: LocalDate): Boolean {
        return if (dayFirstInstallment.isBefore(LocalDate.now().plusMonths(3))) true
        else throw BusinessException("Invalid Date")
    }
}