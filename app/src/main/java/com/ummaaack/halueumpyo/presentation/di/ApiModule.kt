package com.ummaaack.halueumpyo.presentation.di

import com.ummaaack.halueumpyo.data.remote.api.calendar.CalendarService
import com.ummaaack.halueumpyo.data.remote.api.diary.DiaryService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideDiaryService(retrofit: Retrofit): DiaryService {
        return retrofit.create(DiaryService::class.java)
    }

    @Provides
    @Singleton
    fun provideCalendarService(retrofit: Retrofit): CalendarService {
        return retrofit.create(CalendarService::class.java)
    }
}