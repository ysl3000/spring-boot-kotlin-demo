package hello.repositories

import hello.skindata.responsedata.ProfileSkinResponse
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * Created by ysl3000
 */

@Repository
interface SkinDataRepository : CrudRepository<ProfileSkinResponse,Long>{
    fun findSkinByPlayerUUID(playerUUID: String) : ProfileSkinResponse?
    fun findSkinByName(Name: String) : List<ProfileSkinResponse>
    fun existsByPlayerUUID(playerUUID: String) : Boolean
}