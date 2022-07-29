package com.hyunju.movieapp.data.api

import com.google.firebase.firestore.FirebaseFirestore
import com.hyunju.movieapp.domain.model.User
import kotlinx.coroutines.tasks.await

class UserFirestoreApi(
    private val firestore: FirebaseFirestore
) : UserApi {

    override suspend fun saveUser(user: User): User =
        firestore.collection("users")
            .add(user)
            .await()
            .let { User(it.id) }
}