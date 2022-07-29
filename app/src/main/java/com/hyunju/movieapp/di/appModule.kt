package com.hyunju.movieapp.di

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.hyunju.movieapp.data.api.MovieApi
import com.hyunju.movieapp.data.api.MovieFirestoreApi
import com.hyunju.movieapp.data.api.ReviewApi
import com.hyunju.movieapp.data.api.ReviewFirestoreApi
import com.hyunju.movieapp.data.repository.MovieRepository
import com.hyunju.movieapp.data.repository.MovieRepositoryImpl
import com.hyunju.movieapp.data.repository.ReviewRepository
import com.hyunju.movieapp.data.repository.ReviewRepositoryImpl
import com.hyunju.movieapp.domain.usecase.GetAllMoviesUseCase
import com.hyunju.movieapp.domain.usecase.GetRandomFeaturedMovieUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val appModule = module {
    single { Dispatchers.IO }
}

val dataModule = module {
    single { Firebase.firestore }

    single<MovieApi> { MovieFirestoreApi(get()) }
    single<ReviewApi> { ReviewFirestoreApi(get()) }

    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
    single<ReviewRepository> { ReviewRepositoryImpl(get(), get()) }
}

val domainModule = module {
    factory { GetRandomFeaturedMovieUseCase(get(), get()) }
    factory { GetAllMoviesUseCase(get()) }
}

val presenterModule = module {
}
