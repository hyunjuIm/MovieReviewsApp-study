package com.hyunju.movieapp.presentation.mypage

import com.hyunju.movieapp.domain.model.ReviewedMovie
import com.hyunju.movieapp.presentation.BasePresenter
import com.hyunju.movieapp.presentation.BaseView

interface MyPageContract {

    interface View : BaseView<Presenter> {

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showNoDataDescription(message: String)

        fun showErrorDescription(message: String)

        fun showReviewedMovies(reviewedMovies: List<ReviewedMovie>)
    }

    interface Presenter : BasePresenter
}