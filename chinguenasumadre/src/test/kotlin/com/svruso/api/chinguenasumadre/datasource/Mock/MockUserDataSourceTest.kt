package com.svruso.api.chinguenasumadre.datasource.Mock

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MockUserDataSourceTest{

    private val mockUserDataSource = MockUserDataSource()

    // Estamos testeando POJOs

    @Test
    fun `should provide a collection of users`(){
        // Given


        // When
        val users = mockUserDataSource.retrieveUsers()

        // Then
        // Verificamos que la lista de usuarios no sea nula
        assertNotNull(users)
        assertTrue(users.size >= 3)
    }

    @Test
    fun `should provide some mock data`(){
        // given


        // when
        val users = mockUserDataSource.retrieveUsers()

        // then

        // AJAJ estos no sirven xd, preguntarle a hana xd
        assertTrue(users.any{ it.name.isNotEmpty() })
        assertTrue(users.any{ it.apellido.isNotEmpty() })
        assertTrue(users.any{ it.email.isNotEmpty() })
        assertTrue(users.any{ it.edad > 0 })



    }


}