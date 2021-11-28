package com.angogasapps.myfamily.repositories

import com.angogasapps.myfamily.entities.User
import org.springframework.stereotype.Repository

@Repository
class UserRepository {

    fun getUser(id: String): User {
        return User()
    }

    fun updateUser(user: User) {

    }
}