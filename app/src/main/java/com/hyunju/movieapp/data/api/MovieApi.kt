package com.hyunju.movieapp.data.api

import com.hyunju.movieapp.domain.model.Movie

interface MovieApi {

    suspend fun getAllMovies(): List<Movie>
}