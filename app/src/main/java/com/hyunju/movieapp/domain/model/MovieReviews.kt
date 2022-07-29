package com.hyunju.movieapp.domain.model

data class MovieReviews(
    val myReview: Review?,
    val othersReview: List<Review>
)