package com.umc.phrase.remote.api

import com.umc.phrase.remote.model.BookDetailWrapperResponse
import com.umc.phrase.remote.model.ResponseWithPageInfo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("books/{isbn}")
    suspend fun getBookDetail(
        @Path("isbn") isbn: String,
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 20,
        @Query("isBookId") isBookId: Boolean = false
    ): ResponseWithPageInfo<BookDetailWrapperResponse>

    @GET("books/{bookId")
    suspend fun getBookDetail(
        @Path("bookId") bookId: Int,
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 20,
        @Query("isBookId") isBookId: Boolean = true
    ): ResponseWithPageInfo<BookDetailWrapperResponse>
}