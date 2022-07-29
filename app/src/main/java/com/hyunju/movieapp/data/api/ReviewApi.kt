package com.hyunju.movieapp.data.api

import com.hyunju.movieapp.domain.model.Review

interface ReviewApi {

    suspend fun getLatestReview(movieId: String): Review?
}