package dio.bootcamp.tqi.kotlin.creditrequestsystem.controller

import jakarta.validation.Valid
import dio.bootcamp.tqi.kotlin.creditrequestsystem.dto.CustomerDto
import dio.bootcamp.tqi.kotlin.creditrequestsystem.dto.CustomerView
import dio.bootcamp.tqi.kotlin.creditrequestsystem.dto.CustomerUpdateDto
import dio.bootcamp.tqi.kotlin.creditrequestsystem.service.impl.CustomerService
import dio.bootcamp.tqi.kotlin.creditrequestsystem.entity.Customer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.Operation

@RestController
@RequestMapping("/api/customers")
@Tag(name = "API para Clientes", description = "Esta API permite incluir, excluir e pesquisar clientes.")
class CustomerResource(private val customerService: CustomerService) {
    @Operation(summary = "Adiciona cliente", description = "Adiciona um novo cliente.")
    @PostMapping
    fun saveCustomer(@RequestBody @Valid customerDto: CustomerDto): ResponseEntity<CustomerView> {
        System.out.println("CustomerResource.kt -> Save Customer")
        val savedCustomer: Customer = this.customerService.save(customerDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerView(savedCustomer))
    }

    @Operation(summary = "Procura cliente por ID", description = "Busca um cliente cadastrado através de seu ID.")
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
    }

    @Operation(summary = "Remove cliente por ID", description = "Remove um cliente através de seu ID.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Long) = this.customerService.delete(id)

    @Operation(summary = "Atualiza cliente por ID", description = "Atualiza dados de um cliente através de seu ID.")
    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id: Long, 
        @RequestBody @Valid customerUpdateDto: CustomerUpdateDto): ResponseEntity<CustomerView> {
            val customer: Customer = this.customerService.findById(id)
            val customerToUpdate: Customer = customerUpdateDto.toEntity(customer)
            val customerUpdated: Customer = this.customerService.save(customerToUpdate)
            return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerUpdated))
        }
}