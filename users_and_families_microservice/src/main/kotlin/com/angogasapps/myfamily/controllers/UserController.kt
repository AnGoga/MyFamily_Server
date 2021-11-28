package com.angogasapps.myfamily.controllers

import com.angogasapps.myfamily.entities.User
import com.angogasapps.myfamily.repositories.UserRepository
import com.angogasapps.myfamily.values.PATH_USERS
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
class UserController {
    @Autowired
    private lateinit var userRepository: UserRepository

    @GetMapping("${PATH_USERS}/{userId}")
    fun getUser(@PathVariable userId: String): User {
        val user = userRepository.getUser(userId)
        println(userId)
        return user
    }

    @PatchMapping("${PATH_USERS}/{userId}")
    fun updateUser(@PathVariable userId: String, @RequestParam(value = "user") user: User) {
        user.id = userId
        println(userId + user)
        userRepository.updateUser(user)
    }
}