package com.hyunju.movieapp.presentation

interface BaseView<PresenterT : BasePresenter> {

    val presenter: PresenterT
}