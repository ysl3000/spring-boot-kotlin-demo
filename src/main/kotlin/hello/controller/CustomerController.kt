package hello.controller

import hello.data.Customer
import hello.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class CustomerController{

    @Autowired
    private lateinit var repository: CustomerRepository

    @GetMapping("/customers")
    fun findAll(): MutableIterable<Customer> = repository.findAll()


    @GetMapping("/customers/{playerUUID}")
    fun findByLastName(@PathVariable playerUUID: UUID) = repository.findByPlayerUUID(playerUUID)
}