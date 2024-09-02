package com.svruso.api.chinguenasumadre.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.svruso.api.chinguenasumadre.model.User

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.*


/*
* En este caso vamos a usar la capacidad de Spring de testear controladores
*
* */
@SpringBootTest // Esta anotacion es cara
@AutoConfigureMockMvc
class UserControllerTest @Autowired constructor(

     val mockMvc: MockMvc,
     val objectMapper: ObjectMapper
){


    @Nested
    @DisplayName("getUsers()")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetUsers {

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
    }

//    @Nested
//    @DisplayName("getUser()")
//    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
//    inner class GetUser {
//
//        @Test
//        fun `Should return the user given the name`(){
//            // when/then
//            mockMvc.post("/api/users/Samuel")
//                .andDo { print() }
//                .andExpect {
//                    status { isOk() }
//                    content { contentType(MediaType.APPLICATION_JSON) }
//                    jsonPath("$.name") {value("Samuel")}
//
//                }
//
//        }
//    }

    @Nested
    @DisplayName("postUser()")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class postUser {

        @Test
        fun `Should add a new user`() {
            // given
            val newUser = User("Jorge", "Pinoles", "negas@gmail.com", 79)


            // when
            val performPost = mockMvc.post("/api/users") {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(newUser)

            }

            // then
            performPost
                .andDo { print() }
                .andExpect {
                    status { isCreated() }
//                        content { contentType(MediaType.APPLICATION_JSON) }
//                        jsonPath("$.name") {value("Jorge")} // <- Yo no quiero hacer estos 2 porque yo espero nomas un ok, no que responda con el mismo objeto
                }


        }

        @Test
        fun `should return BAD REQUEST if user with name already exists`() {
            // given

            val invalidUser = User("Samuel", "vargas", "quiensabe@gmail.com", 65)

            // when
            val performPost = mockMvc.post("/api/users") {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(invalidUser)

            }

            // then
            performPost
                .andDo { print() }
                .andExpect {
                    status { isBadRequest() }
//                        content { contentType(MediaType.APPLICATION_JSON) }
//                        jsonPath("$.name") {value("Jorge")} // <- Yo no quiero hacer estos 2 porque yo espero nomas un ok, no que responda con el mismo objeto
                }

        }


        @Nested
        @DisplayName("updateUser()")
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        inner class updateUser {

            @Test
            fun `Should update an existing user`() {
                // given
                val updatedUser = User("Samuel", "vargas", "quiensabe@gmail.com", 65)


                // when
                val performUpdate = mockMvc.patch("/api/users") {
                    contentType = MediaType.APPLICATION_JSON
                    content = objectMapper.writeValueAsString(updatedUser)

                }

                // then
                performUpdate
                    .andDo { print() }
                    .andExpect {
                        status { isOk() }
                        content {
                            contentType(MediaType.APPLICATION_JSON)
                            json(objectMapper.writeValueAsString(updatedUser))
                        }
                    }
                mockMvc.get("/api/users/${updatedUser.name}")
                    .andExpect { content { json(objectMapper.writeValueAsString(updatedUser)) } }

            }


        }





    }






    // Esta es una prueba de integracion 






}