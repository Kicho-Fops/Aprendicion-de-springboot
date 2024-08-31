package com.svruso.api.chinguenasumadre.datasource.Mock

import com.svruso.api.chinguenasumadre.datasource.UserDataSource
import com.svruso.api.chinguenasumadre.model.User
import org.springframework.stereotype.Repository


// Marca la clase como bean de Spring
// Le dice que inicialize la clase en el contexto de Spring
// Un bean es un objeto que es instanciado, ensamblado y administrado por un contenedor de IoC
@Repository
class MockUserDataSource: UserDataSource {

    val users = listOf(
        User("Samuel", "Vargas", "hola@gmail.com", 30),
        User("Juan", "Perez", "alo@gmail.com", 30),
        User("Kicho", "fop", "orales@servidoreselruso.com", 20 ),





        )

    override fun retrieveUsers(): Collection<User> = users // Esto basicamente signifa return users


}