package com.hyunju.movieapp.presentation.home

import com.hyunju.movieapp.domain.model.FeaturedMovie
import com.hyunju.movieapp.domain.model.Movie
import com.hyunju.movieapp.presentation.BasePresenter
import com.hyunju.movieapp.presentation.BaseView

interface HomeContract {

    interface View : BaseView<Presenter> {

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showErrorDescription(message: String)

        fun showMovies(
            featuredMovie: FeaturedMovie?,
            movies: List<Movie>
        )
    }

    interface Presenter : BasePresenter
}