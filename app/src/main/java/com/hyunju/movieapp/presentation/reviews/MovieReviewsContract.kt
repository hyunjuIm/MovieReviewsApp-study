package com.hyunju.movieapp.presentation.reviews

import com.hyunju.movieapp.domain.model.Movie
import com.hyunju.movieapp.domain.model.MovieReviews
import com.hyunju.movieapp.domain.model.Review
import com.hyunju.movieapp.presentation.BasePresenter
import com.hyunju.movieapp.presentation.BaseView

interface MovieReviewsContract {

    interface View : BaseView<Presenter> {

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showErrorDescription(message: String)

        fun showMovieInformation(movie: Movie)

        fun showReviews(reviews: MovieReviews)

        fun showErrorToast(message: String)
    }

    interface Presenter : BasePresenter {

        val movie: Movie

        fun requestAddReview(content: String, score: Float)

        fun requestRemoveReview(review: Review)
    }
}