package com.hyunju.movieapp.domain.model

data class FeaturedMovie(
    val movie: Movie,
    val latestReview: Review?
)