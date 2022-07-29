package com.hyunju.movieapp.domain.usecase

import com.hyunju.movieapp.data.repository.ReviewRepository
import com.hyunju.movieapp.domain.model.Review

class DeleteReviewUseCase(
    private val reviewRepository: ReviewRepository
) {
    suspend operator fun invoke(review: Review) =
        reviewRepository.removeReview(review)
}