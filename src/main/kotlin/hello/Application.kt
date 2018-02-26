package hello

import hello.customer.CustomerRepository
import hello.skindata.repositories.SkinDataRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Application {

    private val log = LoggerFactory.getLogger(Application::class.java)



    @Bean
    fun init(repository: CustomerRepository, skinDataRepository: SkinDataRepository) = CommandLineRunner {
        // save a couple of customers
        /*repository.save(Customer(UUID(300, 200), "Jack", "Bauer"))
        repository.save(Customer(UUID(31, 20), "Chloe", "O'Brian"))
        repository.save(Customer(UUID(32, 21), "Kim", "Bauer"))
        repository.save(Customer(UUID(33, 22), "David", "Palmer"))
        repository.save(Customer(UUID(34, 23), "Michelle", "Dessler"))


        val profile = ProfileSkinResponse(UUID(30, 300), "ysl3000")
        val profile2 = ProfileSkinResponse(UUID(9000, 30), "yannick")

        profile.properties = listOf(SkinProperties("textures", "base64"))
        profile2.properties = listOf(SkinProperties("yolo", "base32"))

        skinDataRepository.saveAll(listOf(profile,profile2))
        */

    }

}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
