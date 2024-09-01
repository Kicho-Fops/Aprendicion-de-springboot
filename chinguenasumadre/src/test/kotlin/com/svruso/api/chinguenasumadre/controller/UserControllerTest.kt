package com.svruso.api.chinguenasumadre.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get


/*
* En este caso vamos a usar la capacidad de Spring de testear controladores
*
* */
@SpringBootTest // Esta anotacion es cara
@AutoConfigureMockMvc
class UserControllerTest{


    @Nested
    @DisplayName("")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class {
        
    }


    @Autowired
    lateinit var mockMvc: MockMvc

    // Esta es una prueba de integracion 
    @Test
    fun `should return all users`(){
        // when/then
        mockMvc.get("/api/users")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$[0].name") {value("Samuel")}

            }

    }

    @Test
    fun `Should return the user given the name`(){
        // when/then
        mockMvc.get("/api/users/Jorge")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.name") {value("Samuel")}

            }

    }



}