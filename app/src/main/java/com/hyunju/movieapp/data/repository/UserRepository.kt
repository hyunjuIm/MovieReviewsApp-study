package com.hyunju.movieapp.data.repository

import com.hyunju.movieapp.domain.model.User

interface UserRepository {

    suspend fun getUser(): User?

    suspend fun saveUser(user: User)
}