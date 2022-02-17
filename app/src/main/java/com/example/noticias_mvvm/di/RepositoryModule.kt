package com.example.noticias_mvvm.di

import com.example.noticias_mvvm.provider.NewsProvider
import com.example.noticias_mvvm.repository.NewsRepository
import com.example.noticias_mvvm.repository.NewsRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun providerNewsRepository(provider: NewsProvider): NewsRepository =
        NewsRepositoryImp(provider)
}