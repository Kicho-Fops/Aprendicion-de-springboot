package com.svruso.api.chinguenasumadre.datasource

import com.svruso.api.chinguenasumadre.model.User

interface UserDataSource {

    fun retrieveUsers(): Collection<User>
}