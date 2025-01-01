package com.umc.phrase.remote

import com.google.gson.GsonBuilder
import com.umc.phrase.BuildConfig
import com.umc.phrase.remote.api.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

private const val API_VERSION = "v1"
private const val TIME_OUT = 30
private var JWT_TOKEN: String? = null

fun createApiService(): ApiService {
    val okHttpClient = OkHttpClient.Builder().apply {
        readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
        writeTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
        connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)

        addNetworkInterceptor(RequestHeaderInterceptor())

    }.build()

    val gson = GsonBuilder()
        .setDateFormat("yyyy-MM-dd HH:mm:ss")
        .create()

    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(ApiService::class.java)
}

fun setToken(token: String) {
    JWT_TOKEN = token
}

class RequestHeaderInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = try {
            if (JWT_TOKEN != null) {
                chain.request().newBuilder()
                    .apply {
                        addHeader("Authorization", "Bearer $JWT_TOKEN")
                    }
                    .build()
            } else {
                chain.request()
            }
        } catch (exception: Exception) {
            chain.request()
        }

        return chain.proceed(newRequest)
    }
}