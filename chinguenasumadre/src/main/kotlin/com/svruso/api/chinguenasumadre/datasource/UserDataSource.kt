package com.svruso.api.chinguenasumadre.datasource

import com.svruso.api.chinguenasumadre.model.User

interface UserDataSource {

    fun retrieveUsers(): Collection<User>
    fun retrieveUser(userName: String): User
    fun createUser(user: User): User
    fun updateUser(user: User): User
    fun deleteUser(userName: String): User

}