package hello.skindata

import hello.Application
import hello.skindata.repositories.SkinDataRepository
import hello.skindata.responsedata.ProfileSkinResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


/**
 * Created by ysl3000
 */

@RestController
@RequestMapping("session/minecraft/")
class SkinDataController {
    @Autowired
    private lateinit var skinDataRepository: SkinDataRepository
    private val log = LoggerFactory.getLogger(Application::class.java)


    @GetMapping("profile/delete")
    fun deleteAll()= skinDataRepository.deleteAll()


    @GetMapping("profile/{playerUUID}")
    fun findByPlayerUUID(@PathVariable playerUUID: String): ProfileSkinResponse = skinDataRepository.findSkinByPlayerUUID(playerUUID)?: throw Exception("No data with this entity available")


    @GetMapping("profile/name/{name}")
    fun findByPlayerName(@PathVariable name: String): List<ProfileSkinResponse> = skinDataRepository.findSkinByName(name)


    @GetMapping("profile/")
    fun findAll(): Iterable<ProfileSkinResponse> = skinDataRepository.findAll()

    @PostMapping("profile/")
    fun addSkinData(@RequestBody profileSkinResponse: ProfileSkinResponse): ResponseEntity<ProfileSkinResponse>? {


        val exist = skinDataRepository.findSkinByPlayerUUID(playerUUID = profileSkinResponse.playerUUID)

        log.info("User already exists: $exist")

        if (exist != null) {
            throw Exception("Skin Profile is already in db")
        } else return ResponseEntity.ok(skinDataRepository.save(profileSkinResponse))
    }

}