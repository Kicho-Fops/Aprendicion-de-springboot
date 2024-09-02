package com.svruso.api.chinguenasumadre.service

import com.svruso.api.chinguenasumadre.datasource.UserDataSource
import com.svruso.api.chinguenasumadre.model.User

import org.springframework.stereotype.Service

/*
* La capa de servicio es la que se encarga de la logica de negocio
* En este caso, la capa de servicio se encarga de obtener los usuarios
* de la fuente de datos
* Y en caso de ser necesario hacer cualquier tipo de transformacion necesaria
* */


@Service
class UserService(private val dataSource: UserDataSource) {

    fun getUsers(): Collection<User> = dataSource.retrieveUsers()
    fun getUser(userName: String): User = dataSource.retrieveUser(userName)
    fun addUser(user: User): User = dataSource.createUser(user)
    fun updateUser(user: User): User = dataSource.updateUser(user)
    fun deleteUser(userName: String): User = dataSource.deleteUser(userName)


}