package com.svruso.api.chinguenasumadre.service

import com.svruso.api.chinguenasumadre.datasource.UserDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.apache.catalina.User
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class UserServiceTest {


    private val datasource: UserDataSource = mockk(relaxed = true)
    private val userService = UserService(datasource)

    @Test
    fun `should call its data source to retrieve users`(){
        // given
//        every { datasource.retrieveUsers() } returns emptyList()


        // when
        userService.getUsers()

        // then
        verify(exactly = 1) { datasource.retrieveUsers() }

}












}