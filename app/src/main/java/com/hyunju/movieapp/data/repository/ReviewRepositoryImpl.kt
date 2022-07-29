package com.hyunju.movieapp.data.repository

import com.hyunju.movieapp.data.api.ReviewApi
import com.hyunju.movieapp.domain.model.Review
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ReviewRepositoryImpl(
    private val reviewApi: ReviewApi,
    private val dispatchers: CoroutineDispatcher
) : ReviewRepository {

    override suspend fun getLatestReview(movieId: String): Review? = withContext(dispatchers) {
        reviewApi.getLatestReview(movieId)
    }

    override suspend fun getAllReviews(movieId: String): List<Review> = withContext(dispatchers) {
        reviewApi.getAllReviews(movieId)
    }
}