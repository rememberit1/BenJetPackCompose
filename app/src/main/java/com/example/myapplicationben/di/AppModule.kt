package com.example.myapplicationben.di

import android.app.Application
import com.example.myapplicationben.data.manager.LocalUserManagerImpl
import com.example.myapplicationben.domain.manager.LocalUserManager
import com.example.myapplicationben.domain.usecases.AppEntryUseCases
import com.example.myapplicationben.domain.usecases.ReadAppEntry
import com.example.myapplicationben.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

}