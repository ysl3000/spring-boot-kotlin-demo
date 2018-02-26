package hello.error

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by ysl3000
 */

@RestController
class FallBackController {
    @RequestMapping("/")
    fun index(): String ="This is the index page"
}