package com.hyunju.movieapp.domain.usecase

import com.hyunju.movieapp.data.repository.ReviewRepository
import com.hyunju.movieapp.data.repository.UserRepository
import com.hyunju.movieapp.domain.model.MovieReviews
import com.hyunju.movieapp.domain.model.Review
import com.hyunju.movieapp.domain.model.User

class GetAllMovieReviewsUseCase(
    private val userRepository: UserRepository,
    private val reviewRepository: ReviewRepository
) {

    suspend operator fun invoke(movieId: String): MovieReviews {
        val reviews = reviewRepository.getAllMovieReviews(movieId)
        val user = userRepository.getUser()

        if (user == null) {
            userRepository.saveUser(User())

            return MovieReviews(null, reviews)
        }

        return MovieReviews(
            reviews.find { it.userId == user.id },
            reviews.filter { it.userId != user.id }
        )
    }
}