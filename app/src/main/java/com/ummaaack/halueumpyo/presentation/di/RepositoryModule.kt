package com.ummaaack.halueumpyo.presentation.di

import com.ummaaack.halueumpyo.data.remote.datasource.CalendarDataSource
import com.ummaaack.halueumpyo.data.remote.datasource.DiaryDataSource
import com.ummaaack.halueumpyo.data.repository.CalendarRepositoryImpl
import com.ummaaack.halueumpyo.data.repository.DiaryRepositoryImpl
import com.ummaaack.halueumpyo.domain.repository.CalendarRepository
import com.ummaaack.halueumpyo.domain.repository.DiaryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDiaryRepository(diaryDataSource: DiaryDataSource): DiaryRepository {
        return DiaryRepositoryImpl(diaryDataSource)
    }

    @Provides
    @Singleton
    fun provideCalendarRepository(calendarDataSource: CalendarDataSource): CalendarRepository {
        return CalendarRepositoryImpl(calendarDataSource)
    }
}