package com.hyunju.movieapp.data.preference

interface PreferenceManager {

    fun getString(key: String): String?

    fun putString(key: String, value: String)
}