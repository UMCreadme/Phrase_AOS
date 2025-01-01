package com.umc.phrase.domain

sealed class DataResource<out T> {
    class Success<T>(val data: T) : DataResource<T>()
    class Error(val throwable: Throwable) : DataResource<Nothing>()
    class Loading<T>(val data: T? = null) : DataResource<T>()

    companion object {
        fun <T> success(data: T): Success<T> = Success(data)
        fun <T> error(throwable: Throwable): Error = Error(throwable)
        fun <T> loading(data: T? = null): Loading<T> = Loading(data)
    }
}