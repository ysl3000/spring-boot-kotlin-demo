package hello.data

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import javax.persistence.*

/**
 * Created by ysl3000
 */


@Entity
@Table(name = "skin_properties")
data class SkinProperties(
        val name: String,
        val value: String,
        val signature: String? = "",
        @JsonIgnore
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id : Long = 0
) : Serializable