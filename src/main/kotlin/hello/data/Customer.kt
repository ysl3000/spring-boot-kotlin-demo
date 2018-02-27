package hello.data

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Customer(
        val playerUUID: UUID,
        val firstName: String,
        val texture: String,
        @Id @GeneratedValue
        val id: Long = -1)
