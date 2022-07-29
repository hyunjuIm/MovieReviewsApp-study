package com.hyunju.movieapp.di

import android.app.Activity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.hyunju.movieapp.data.api.*
import com.hyunju.movieapp.data.preference.PreferenceManager
import com.hyunju.movieapp.data.preference.SharedPreferenceManager
import com.hyunju.movieapp.data.repository.*
import com.hyunju.movieapp.domain.model.Movie
import com.hyunju.movieapp.domain.usecase.*
import com.hyunju.movieapp.presentation.home.HomeContract
import com.hyunju.movieapp.presentation.home.HomeFragment
import com.hyunju.movieapp.presentation.home.HomePresenter
import com.hyunju.movieapp.presentation.mypage.MyPageContract
import com.hyunju.movieapp.presentation.mypage.MyPageFragment
import com.hyunju.movieapp.presentation.mypage.MyPagePresenter
import com.hyunju.movieapp.presentation.reviews.MovieReviewsContract
import com.hyunju.movieapp.presentation.reviews.MovieReviewsFragment
import com.hyunju.movieapp.presentation.reviews.MovieReviewsPresenter
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { Dispatchers.IO }
}

val dataModule = module {
    single { Firebase.firestore }

    single<MovieApi> { MovieFirestoreApi(get()) }
    single<ReviewApi> { ReviewFirestoreApi(get()) }
    single<UserApi> { UserFirestoreApi(get()) }

    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
    single<ReviewRepository> { ReviewRepositoryImpl(get(), get()) }
    single<UserRepository> { UserRepositoryImpl(get(), get(), get()) }

    single { androidContext().getSharedPreferences("preference", Activity.MODE_PRIVATE) }
    single<PreferenceManager> { SharedPreferenceManager(get()) }
}

val domainModule = module {
    factory { GetRandomFeaturedMovieUseCase(get(), get()) }
    factory { GetAllMoviesUseCase(get()) }
    factory { GetAllMovieReviewsUseCase(get(), get()) }
    factory { GetMyReviewedMoviesUseCase(get(), get(), get()) }
    factory { SubmitReviewUseCase(get(), get()) }
    factory { DeleteReviewUseCase(get()) }
}

val presenterModule = module {
    scope<HomeFragment> {
        scoped<HomeContract.Presenter> { HomePresenter(getSource(), get(), get()) }
    }
    scope<MovieReviewsFragment> {
        scoped<MovieReviewsContract.Presenter> { (movie: Movie) ->
            MovieReviewsPresenter(movie, getSource(), get(), get(), get())
        }
    }
    scope<MyPageFragment> {
        scoped<MyPageContract.Presenter> { MyPagePresenter(getSource(), get()) }
    }
}
