package com.rationalagent.transactionsvalidator.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/")
    fun hello(): String = "Hello, Kotlin!"

}