package hello.repositories

import hello.data.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CustomerRepository : CrudRepository<Customer, Long> {

	fun findByPlayerUUID(playerUUID: UUID): Iterable<Customer>
}
