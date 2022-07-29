package com.hyunju.movieapp.domain.usecase

import com.hyunju.movieapp.data.repository.ReviewRepository
import com.hyunju.movieapp.domain.model.Review

class GetAllMovieReviewsUseCase(private val reviewRepository: ReviewRepository) {

    suspend operator fun invoke(movieId: String): List<Review> =
        reviewRepository.getAllMovieReviews(movieId)

}