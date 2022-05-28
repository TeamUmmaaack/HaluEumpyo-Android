package com.ummaaack.halueumpyo.presentation.di

import com.ummaaack.halueumpyo.data.remote.api.calendar.CalendarService
import com.ummaaack.halueumpyo.data.remote.api.diary.DiaryService
import com.ummaaack.halueumpyo.data.remote.datasource.CalendarDataSource
import com.ummaaack.halueumpyo.data.remote.datasource.CalendarDataSourceImpl
import com.ummaaack.halueumpyo.data.remote.datasource.DiaryDataSource
import com.ummaaack.halueumpyo.data.remote.datasource.DiaryDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideDiaryDatasource(diaryService: DiaryService): DiaryDataSource {
        return DiaryDataSourceImpl(diaryService)
    }

    @Provides
    @Singleton
    fun provideCalendarDatasource(calendarService: CalendarService): CalendarDataSource {
        return CalendarDataSourceImpl(calendarService)
    }
}