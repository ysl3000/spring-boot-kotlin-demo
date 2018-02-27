package hello.skindata.responsedata

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import javax.persistence.*

/**
 * Created by ysl3000
 */


@Entity
@Table(name= "skin_profile")
data class ProfileSkinResponse(
        @Column(unique = true,length = 36)
        val playerUUID: String,
        val name: String,
        @OneToMany(cascade = [CascadeType.ALL])
        var properties: List<SkinProperties> = emptyList(),
        @JsonIgnore
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        val id: Long = 0
)  : Serializable