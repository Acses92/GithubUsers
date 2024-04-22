package ru.kravchenkoanatoly.githubusers.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kravchenkoanatoly.githubusers.SearchNavigationProviderImpl
import ru.kravchenkoanatoly.githubusers.UserDetailNavigationProviderImpl
import ru.kravchenkoanatoly.githubusers.detail.UserDetailNavigationProvider
import ru.kravchenkoanatoly.githubusers.search.SearchNavigationProvider

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {
    @Binds
    fun bindSearchNavigationProvider(arg: SearchNavigationProviderImpl): SearchNavigationProvider

    @Binds
    fun bindUserDetailNavigationProvider(ars: UserDetailNavigationProviderImpl): UserDetailNavigationProvider
}