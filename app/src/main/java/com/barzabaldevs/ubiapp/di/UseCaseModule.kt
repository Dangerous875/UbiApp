package com.barzabaldevs.ubiapp.di

import com.barzabaldevs.ubiapp.data.RepositoryImpl
import com.barzabaldevs.ubiapp.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Binds
    abstract fun bindRepository(repository: RepositoryImpl): Repository
}