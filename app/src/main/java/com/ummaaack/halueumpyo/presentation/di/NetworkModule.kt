package com.ummaaack.halueumpyo.presentation.di

import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import com.ummaaack.halueumpyo.BuildConfig
import dagger.Module
import dagger.Provides

import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

private val BASE_URL = "https://asia-northeast3-haluempyo.cloudfunctions.net/api/"


    private val gson = GsonBuilder().setLenient().create()

    private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    private fun getOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor())
        .addInterceptor(AuthInterceptor())
        .build()

    @Provides
    @Singleton
    fun provideRetrofitObjectGson(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
    }
}

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.addHeader("x-access-token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjQsImVtYWlsIjoiYWxhbGVrcWxzMjJAbmF2ZXIuY29tIiwiaWRGaXJlYmFzZSI6IkNwNkM2RkkzejNjcjliZ0FSRGQ1Y0pKcUh5czIiLCJpYXQiOjE2NTQ4NTA0NzMsImV4cCI6MTY1NjA2MDA3MywiaXNzIjoiaGFsdWV1bXB5byJ9.2jxZUwy2y9QLXYzWbLCszbvy2YJmwTeLPNc6VPRqOOw")
        return chain.proceed(requestBuilder.build())
    }
}