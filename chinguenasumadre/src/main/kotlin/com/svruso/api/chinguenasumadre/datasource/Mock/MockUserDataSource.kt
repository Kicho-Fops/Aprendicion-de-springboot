package com.svruso.api.chinguenasumadre.datasource.Mock

import com.svruso.api.chinguenasumadre.datasource.UserDataSource
import com.svruso.api.chinguenasumadre.model.User
import org.springframework.stereotype.Repository


// Marca la clase como bean de Spring
// Le dice que inicialize la clase en el contexto de Spring
// Un bean es un objeto que es instanciado, ensamblado y administrado por un contenedor de IoC
@Repository
class MockUserDataSource: UserDataSource {

    val users = mutableListOf(
        User("Samuel", "Vargas", "hola@gmail.com", 30),
        User("Juan", "Perez", "alo@gmail.com", 30),
        User("Kicho", "fop", "orales@servidoreselruso.com", 20 ),





        )

    override fun retrieveUsers(): Collection<User> = users // Esto basicamente signifa return users
    override fun retrieveUser(userName: String): User =
        users.firstOrNull() { it.name == userName }
        ?: throw NoSuchElementException("Could not find user with name $userName")// Arroja un NoSuchElement si no existe el elemento

    override fun createUser(user: User): User {
        if(users.any { it.name == user.name }) { // It se refiere como al this -> en c++
            throw IllegalArgumentException("User with name ${user.name} already exists")
        }
        users.add(user)

        return user
    }

    override fun updateUser(user: User): User {
        val currentUser = users.firstOrNull { it.name == user.name }
            ?: throw NoSuchElementException("Could not find user with name ${user.name}")

        users.remove(currentUser)
        users.add(user)

        return user

    }

    override fun deleteUser(userName: String): User {
        val user = users.firstOrNull { it.name == userName }
            ?: throw NoSuchElementException("Could not find user with name $userName")

        users.remove(user)

        return user
    }


}