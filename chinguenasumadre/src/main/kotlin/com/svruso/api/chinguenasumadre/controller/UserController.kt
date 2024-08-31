package com.svruso.api.chinguenasumadre.controller

import com.svruso.api.chinguenasumadre.model.User
import com.svruso.api.chinguenasumadre.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getUsers(): Collection<User> = userService.getUsers()




}