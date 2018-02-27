package hello.controller

import hello.Application
import hello.repositories.SkinDataRepository
import hello.data.ProfileSkinResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.web.bind.annotation.*


/**
 * Created by ysl3000
 */

@RestController
@RequestMapping("session/minecraft/profile")
class SkinDataController {
    @Autowired
    private lateinit var skinDataRepository: SkinDataRepository
    private val log = LoggerFactory.getLogger(Application::class.java)


    @CacheEvict(value = ["skin-list"])
    @GetMapping("/delete")
    fun deleteAll()= skinDataRepository.deleteAll()


    @Cacheable(value = ["skin-single"],key = "#playerUUID", unless = "#result==null")
    @GetMapping("/{playerUUID}")
    fun findByPlayerUUID(@PathVariable playerUUID: String): ProfileSkinResponse = skinDataRepository.findSkinByPlayerUUID(playerUUID)?: throw Exception("No data with this entity available")

    @Cacheable(value = ["skin-list"],key = "#name")
    @GetMapping("/name/{name}")
    fun findByPlayerName(@PathVariable name: String): List<ProfileSkinResponse> = skinDataRepository.findSkinByName(name)


    @GetMapping("/")
    fun findAll(): Iterable<ProfileSkinResponse> = skinDataRepository.findAll()

    @CachePut(value= ["skin-single"],key = "#profileSkinResponse.playerUUID")
    @PostMapping("/")
    fun addSkinData(@RequestBody profileSkinResponse: ProfileSkinResponse): ProfileSkinResponse? {


        val exist = skinDataRepository.findSkinByPlayerUUID(playerUUID = profileSkinResponse.playerUUID)

        log.info("User already exists: $exist")

        if (exist != null) {
            throw Exception("Skin Profile is already in db")
        } else return skinDataRepository.save(profileSkinResponse)
    }

}