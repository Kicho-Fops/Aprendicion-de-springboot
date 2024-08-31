package com.svruso.api.chinguenasumadre.model

/*
* Este es el data Layer
* Escencialmente el data class user es un DTO
*
*
*
* */


data class User(
    // Asi es para asignar un constructor primario
    var name: String = "",
    // Si quisiera hacer un getter y setter personalizado
    // get() = field.toUpperCase()
    // set(value) { field = value }
    var apellido: String = "",
    var email: String = "",
    var edad: Int = 0
)
//{

    // Asi es para asignar un constructor secundario
    // constructor(name: String, apellido: String, email: String, edad: Int) : this(name, apellido, email, edad)
    // constructor(name: String, apellido: String, email: String) : this(name, apellido, email, 0) -> constructor por defecto pero 2

    // Kotlin genera automaticamente los getters y setters






//}