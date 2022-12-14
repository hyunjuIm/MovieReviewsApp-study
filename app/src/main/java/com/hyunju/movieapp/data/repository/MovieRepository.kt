package com.hyunju.movieapp.data.repository

import com.hyunju.movieapp.domain.model.Movie

interface MovieRepository {

    suspend fun getAllMovies(): List<Movie>

    suspend fun getMovies(movieIds: List<String>): List<Movie>
}