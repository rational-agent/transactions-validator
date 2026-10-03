package com.rationalagent.transactionsvalidator.api

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.hamcrest.Matchers.containsString
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(HelloController::class)
@ExtendWith(SpringExtension::class)
class HelloControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `GET should return 200 OK and hello message`() {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk)
            .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
            .andExpect(content().string("Hello, Kotlin!"))
    }

    @Test
    fun `POST should accept csv file upload`() {
        val csv = MockMultipartFile(
            "file",
            "transactions.csv",
            "text/csv",
            "id,amount\n1,100.50\n".toByteArray()
        )

        mockMvc.perform(multipart("/csv").file(csv))
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("transactions.csv")))
    }
}