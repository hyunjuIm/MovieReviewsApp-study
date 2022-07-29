package com.hyunju.movieapp.domain.usecase

import com.hyunju.movieapp.data.repository.MovieRepository
import com.hyunju.movieapp.domain.model.Movie

class GetAllMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(): List<Movie> = movieRepository.getAllMovies()
}
