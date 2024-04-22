package ru.kravchenkoanatoly.githubusers.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kravchenkoanatoly.githubusers.data.repositories.GithubSearchRepositoryImpl
import ru.kravchenkoanatoly.githubusers.data.repositories.GithubUsersRepositoryImpl
import ru.kravchenkoanatoly.githubusers.repositories.GithubSearchRepository
import ru.kravchenkoanatoly.githubusers.repositories.GithubUsersRepository

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class BindModule{
        @Binds
        abstract fun bingGithubSearchRepository(arg: GithubSearchRepositoryImpl): GithubSearchRepository

        @Binds
        abstract fun bingGithubUserRepository(arg: GithubUsersRepositoryImpl): GithubUsersRepository
    }


}