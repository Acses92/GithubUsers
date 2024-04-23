package ru.kravchenkoanatoly.githubusers.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.kravchenkoanatoly.githubusers.common.AppConstants.APP_DATABASE
import ru.kravchenkoanatoly.githubusers.data.repositories.DatabaseRepositoryImpl
import ru.kravchenkoanatoly.githubusers.data.repositories.GithubSearchRepositoryImpl
import ru.kravchenkoanatoly.githubusers.data.repositories.GithubUsersRepositoryImpl
import ru.kravchenkoanatoly.githubusers.data.sources.database.AppDatabase
import ru.kravchenkoanatoly.githubusers.repositories.DatabaseRepository
import ru.kravchenkoanatoly.githubusers.repositories.GithubSearchRepository
import ru.kravchenkoanatoly.githubusers.repositories.GithubUsersRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, APP_DATABASE)
            .build()

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class BindModule{
        @Binds
        abstract fun bingGithubSearchRepository(arg: GithubSearchRepositoryImpl): GithubSearchRepository

        @Binds
        abstract fun bingGithubUserRepository(arg: GithubUsersRepositoryImpl): GithubUsersRepository

        @Binds
        abstract fun bindDatabaseRepository(arg: DatabaseRepositoryImpl): DatabaseRepository
    }


}