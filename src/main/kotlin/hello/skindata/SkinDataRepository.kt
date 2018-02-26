package hello

import hello.responsedata.ProfileSkinResponce
import org.springframework.data.repository.CrudRepository
import java.util.*

/**
 * Created by ysl3000
 */

interface SkinDataRepository : CrudRepository<ProfileSkinResponce,Long>{
    fun findSkinByPlayerUUID(playerUUID: UUID) : ProfileSkinResponce?
}