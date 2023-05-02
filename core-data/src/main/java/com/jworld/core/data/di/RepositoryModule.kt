package com.jworld.core.data.di

import com.jworld.core.data.user.repository.NetworkUserRepository
import com.jworld.core.data.user.repository.UserRepository
import com.jworld.network.reqres.UserNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindNetworkUserRepository(repository: NetworkUserRepository): UserRepository
}