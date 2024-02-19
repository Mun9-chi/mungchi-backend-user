package org.mungchi.user

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.logging.Logger
@RestController
class TestController {
    val logger = LoggerFactory.getLogger(this.javaClass)
    @GetMapping("/test")
    fun test(): String {
        logger.info("test")
        return "Hello, World!"
    }
}