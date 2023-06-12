package dio.bootcamp.tqi.kotlin.creditrequestsystem.controller

import jakarta.validation.Valid
import dio.bootcamp.tqi.kotlin.creditrequestsystem.service.impl.CreditService
import dio.bootcamp.tqi.kotlin.creditrequestsystem.dto.CreditDto
import dio.bootcamp.tqi.kotlin.creditrequestsystem.dto.CreditViewList
import dio.bootcamp.tqi.kotlin.creditrequestsystem.entity.Credit
import dio.bootcamp.tqi.kotlin.creditrequestsystem.dto.CreditView
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import java.util.UUID
import java.util.stream.Collectors
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.Operation

@RestController
@RequestMapping("/api/credits")
@Tag(name = "API para Créditos", description = "Esta API permite incluir e pesquisar financiamentos dos clientes.")
class CreditResource(private val creditService: CreditService) {
    @Operation(summary = "Novo financiamento para cliente", description = "Adiciona um novo financiamento para cliente cadastrado.")
    @PostMapping
    fun saveCredit(@RequestBody @Valid creditDto: CreditDto): ResponseEntity<String> {
        // System.out.println("CreditResource.kt -> Save Credit")
        val savedCredit: Credit = this.creditService.save(creditDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Credit ${savedCredit.creditCode} - Customer ${savedCredit.customer?.email} saved!")
    }

    @Operation(summary = "Busca financiamentos por ID do cliente", description = "Procura todos os financiamentos de um cliente utilizando seu ID cadastrado.")
    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long): ResponseEntity<List<CreditViewList>> {
        val creditViewList: List<CreditViewList> = this.creditService.findAllByCustomer(customerId)
            .stream()
            .map { credit: Credit -> CreditViewList(credit) }
            .collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
    }

    @Operation(summary = "Busca financiamento por código da transação e ID do cliente", description = "Procura um financiamento através de um código de operação cadastrado, restrito a determinado cliente.")
    @GetMapping("/{creditCode}")
    fun findByCreditCode(@RequestParam(value = "customerId") customerId: Long,
                        @PathVariable creditCode: UUID): ResponseEntity<CreditView> {
        val credit: Credit = this.creditService.findByCreditCode(customerId, creditCode)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }
}