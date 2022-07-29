package com.hyunju.movieapp.data.repository

import com.hyunju.movieapp.domain.model.Review

interface ReviewRepository {

    suspend fun getLatestReview(movieId: String): Review?
}