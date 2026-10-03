package com.rationalagent.transactionsvalidator.api

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class HelloController {

    @GetMapping("/")
    fun hello(): String = "Hello, Kotlin!"

    @PostMapping("/csv", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun uploadCsv(@RequestParam("file") file: MultipartFile): String =
        "Received ${file.originalFilename} with ${file.size} bytes"
}