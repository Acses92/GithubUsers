package ru.kravchenkoanatoly.githubusers.data.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import ru.kravchenkoanatoly.githubusers.data.mappers.toDomain
import ru.kravchenkoanatoly.githubusers.data.sources.database.AppDatabase
import ru.kravchenkoanatoly.githubusers.models.GithubUserSearchDomain
import ru.kravchenkoanatoly.githubusers.repositories.DatabaseRepository
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase
) : DatabaseRepository {
    override fun subscribeGithubUserSearch(): Flow<List<GithubUserSearchDomain>> =
            appDatabase.githubSearchUserDao().subscribeGithubUserSearch()
                .map { githubSearchEntity -> githubSearchEntity.map { it.toDomain() } }

    override fun dellSearchResultCache(): Flow<Unit> = flow {
        emit(appDatabase.githubSearchUserDao().deleteAll())
    }
}