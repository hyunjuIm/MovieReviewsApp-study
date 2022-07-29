package com.hyunju.movieapp.data.api

import com.hyunju.movieapp.domain.model.User

interface UserApi {

    suspend fun saveUser(user: User): User
}