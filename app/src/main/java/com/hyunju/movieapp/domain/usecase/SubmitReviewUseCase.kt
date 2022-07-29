package com.hyunju.movieapp.domain.usecase

import com.hyunju.movieapp.data.repository.ReviewRepository
import com.hyunju.movieapp.data.repository.UserRepository
import com.hyunju.movieapp.domain.model.Movie
import com.hyunju.movieapp.domain.model.Review
import com.hyunju.movieapp.domain.model.User

class SubmitReviewUseCase(
    private val userRepository: UserRepository,
    private val reviewRepository: ReviewRepository
) {

    suspend operator fun invoke(
        movie: Movie,
        content: String,
        score: Float
    ): Review {
        var user = userRepository.getUser()

        if (user == null) {
            userRepository.saveUser(User())
            user = userRepository.getUser()
        }

        return reviewRepository.addReview(
            Review(
                userId = user!!.id,
                movieId = movie.id,
                content = content,
                score = score
            )
        )
    }
}